package io.micronaut.http.server.netty;

import java.net.URI;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.http.server.netty.handler.PipeliningServerHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpMethod;

@Weave
public abstract class RoutingInBoundHandler {

	@Trace
	public void accept(ChannelHandlerContext ctx, io.netty.handler.codec.http.HttpRequest request, PipeliningServerHandler.OutboundAccess outboundAccess) {
		if(request != null) {
			StringBuffer sb = new StringBuffer();
			HttpMethod method = request.method();
			if(method != null) {
				sb.append(method.name());
			} else {
				sb.append("UnknownMethod");
			}
			sb.append(" - ");
			String uri = request.uri();
			if(uri != null) {
				sb.append(uri);
			} else {
				sb.append("UnknownURI");
			}
			NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_LOW, false, "Micronaut-Netty", sb.toString());
		}
		Weaver.callOriginal();
	}
}
