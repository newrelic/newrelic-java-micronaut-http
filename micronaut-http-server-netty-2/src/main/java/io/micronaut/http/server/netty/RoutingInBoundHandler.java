package io.micronaut.http.server.netty;

import java.util.List;
import java.util.logging.Level;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.micronaut.netty_2.Utils;

import io.micronaut.http.HttpHeaders;
import io.micronaut.web.router.RouteMatch;
import io.netty.channel.ChannelHandlerContext;

@Weave
abstract class RoutingInBoundHandler {

	@Trace
	protected void channelRead0(ChannelHandlerContext ctx, io.micronaut.http.HttpRequest<?> request) {
		Weaver.callOriginal();
	}		
		

	
	@SuppressWarnings("unused")
	private void handleRouteMatch(RouteMatch<?> route, NettyHttpRequest<?> request,ChannelHandlerContext context, boolean skipOncePerRequest) {
		Utils.decorateWithRoute(route);
		HttpHeaders headers = request.getHeaders();
		if(headers != null) {
			for(String key : headers.names()) {
				List<String> values = headers.getAll(key);
				NewRelic.getAgent().getLogger().log(Level.FINE, "Header values for {0}: {1}", key, values);
			}
		}
		Weaver.callOriginal();
	}
		
}
