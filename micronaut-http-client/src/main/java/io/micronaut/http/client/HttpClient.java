package io.micronaut.http.client;

import org.reactivestreams.Publisher;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;

@SuppressWarnings("rawtypes")
@Weave(type = MatchType.Interface)
public abstract class HttpClient {

	@Trace
	public <I, O, E> Publisher<HttpResponse<O>> exchange(HttpRequest<I> request, Argument<O> bodyType, Argument<E> errorType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"exchange");
    	return Weaver.callOriginal();
    }

	@Trace
    public <I, O> Publisher<HttpResponse<O>> exchange(HttpRequest<I> request, Argument<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"exchange");
        return Weaver.callOriginal();
    }

	@Trace
	public <I> Publisher<HttpResponse<ByteBuffer>> exchange(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"exchange");
        return Weaver.callOriginal();
    }

	@Trace
    public Publisher<HttpResponse<ByteBuffer>> exchange(String uri) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"exchange");
        return Weaver.callOriginal();
    }

	@Trace
    public <O> Publisher<HttpResponse<O>> exchange(String uri, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"exchange");
        return Weaver.callOriginal();
    }

	@Trace
    public <I, O> Publisher<HttpResponse<O>> exchange(HttpRequest<I> request, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"exchange");
        return Weaver.callOriginal();
    }

	@Trace
    public <I, O, E> Publisher<O> retrieve(HttpRequest<I> request, Argument<O> bodyType, Argument<E> errorType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public <I, O> Publisher<O> retrieve(HttpRequest<I> request, Argument<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public <I, O> Publisher<O> retrieve(HttpRequest<I> request, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public <I> Publisher<String> retrieve(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public Publisher<String> retrieve(String uri) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","HttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

}
