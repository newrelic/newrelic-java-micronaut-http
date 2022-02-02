package io.micronaut.http.client;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.reactivex.Flowable;

@Weave(type = MatchType.Interface)
public abstract class RxProxyHttpClient {

	@Trace
	public Flowable<MutableHttpResponse<?>> proxy(HttpRequest<?> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxProxyHttpClient",getClass().getSimpleName(),"proxy");
		return Weaver.callOriginal();
	}
}
