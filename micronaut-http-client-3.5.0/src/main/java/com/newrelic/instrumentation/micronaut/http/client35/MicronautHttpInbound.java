package com.newrelic.instrumentation.micronaut.http.client35;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.InboundHeaders;

import io.micronaut.http.HttpResponse;

public class MicronautHttpInbound<B> implements InboundHeaders {
	
	private HttpResponse<B> response;
	
	public MicronautHttpInbound(HttpResponse<B> resp) {
		response =  resp;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public String getHeader(String name) {
		if(response != null) {
			return response.header(name);
		}
		return null;
	}

}
