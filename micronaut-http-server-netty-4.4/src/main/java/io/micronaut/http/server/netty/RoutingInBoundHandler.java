package io.micronaut.http.server.netty;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.http.server.netty.body.ByteBody;
import io.micronaut.http.server.netty.handler.OutboundAccess;
import io.micronaut.http.server.netty.handler.PipeliningServerHandler;
import io.netty.channel.ChannelHandlerContext;

@Weave
public abstract class RoutingInBoundHandler {

	@Trace(dispatcher = true)
	 public void accept(ChannelHandlerContext ctx, io.netty.handler.codec.http.HttpRequest request, ByteBody body, OutboundAccess outboundAccess)  {
		Weaver.callOriginal();
	}
}
