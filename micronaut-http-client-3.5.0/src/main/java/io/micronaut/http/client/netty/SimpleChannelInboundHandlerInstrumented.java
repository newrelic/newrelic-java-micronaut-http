package io.micronaut.http.client.netty;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.scheduling.instrument.InvocationInstrumenter;
import io.netty.channel.ChannelHandlerContext;

@Weave(type = MatchType.BaseClass)
abstract class SimpleChannelInboundHandlerInstrumented<I> {

	@NewField
	private Token token = null;
	
	SimpleChannelInboundHandlerInstrumented(InvocationInstrumenter instrumenter) {
    	token = NewRelic.getAgent().getTransaction().getToken();
    }

	SimpleChannelInboundHandlerInstrumented(InvocationInstrumenter instrumenter, boolean autoRelease) {
    	token = NewRelic.getAgent().getTransaction().getToken();
    }
    
    @Trace(async = true)
    protected void channelReadInstrumented(ChannelHandlerContext ctx, I msg) {
    	if(token != null) {
    		token.linkAndExpire();
    		token = null;
    	}
    	Weaver.callOriginal();
    }
    
    @Trace(async = true)
    protected void channelRead0(ChannelHandlerContext ctx, I msg) {
    	if(token != null) {
    		token.linkAndExpire();
    		token = null;
    	}
    	Weaver.callOriginal();
    }
}

