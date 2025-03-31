package io.micronaut.http.server.netty;

import java.net.URI;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.http.HttpMethod;
import io.netty.channel.ChannelHandlerContext;

@Weave
abstract class RoutingInBoundHandler {

	@Trace(dispatcher = true)
	protected void channelRead0(ChannelHandlerContext ctx, io.micronaut.http.HttpRequest<?> request) {
		if(request != null) {
			StringBuffer sb = new StringBuffer();
			HttpMethod method = request.getMethod();
			if(method != null) {
				sb.append(method.name());
			} else {
				sb.append("UnknownMethod");
			}
			sb.append(" - ");
			URI uri = request.getUri();
			if(uri != null) {
				sb.append(uri.toASCIIString());
			} else {
				sb.append("UnknownURI");
			}
			NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_LOW, false, "Micronaut-Netty", sb.toString());
		}
		Weaver.callOriginal();
	}		
		
}
