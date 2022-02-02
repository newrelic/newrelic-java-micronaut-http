package io.micronaut.http.client;

import org.reactivestreams.Publisher;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;

@Weave(type = MatchType.Interface)
public abstract class ProxyHttpClient {

	@Trace
	public Publisher<MutableHttpResponse<?>> proxy(HttpRequest<?> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","ProxyHttpClient",getClass().getSimpleName(),"proxy");
		return Weaver.callOriginal();
	}
}
