package io.micronaut.http.server.netty.websocket;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.http.server.netty.body.ByteBody;
import io.micronaut.http.server.netty.handler.PipeliningServerHandler;
import io.netty.channel.ChannelHandlerContext;

@Weave
public abstract class NettyServerWebSocketUpgradeHandler {

	@Trace(dispatcher = true)
	public void accept(ChannelHandlerContext ctx, io.netty.handler.codec.http.HttpRequest request, ByteBody body, PipeliningServerHandler.OutboundAccess outboundAccess) {
		Weaver.callOriginal();
	}

}
