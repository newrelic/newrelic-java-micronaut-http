package io.micronaut.http.client;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.reactivex.Flowable;

@SuppressWarnings("rawtypes")
@Weave(type = MatchType.Interface)
public abstract class RxHttpClient {

	@Trace
	public <I, O> Flowable<HttpResponse<O>> exchange(HttpRequest<I> request, Argument<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}

	@Trace
	public <I, O, E> Flowable<HttpResponse<O>> exchange(HttpRequest<I> request, Argument<O> bodyType, Argument<E> errorType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}

	@Trace
	public <I, O, E> Flowable<O> retrieve(HttpRequest<I> request, Argument<O> bodyType, Argument<E> errorType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"retrieve");
		return Weaver.callOriginal();
	}

	@Trace
	public <I> Flowable<HttpResponse<ByteBuffer>> exchange(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}

	@Trace
	public Flowable<HttpResponse<ByteBuffer>> exchange(String uri) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}

	@Trace
	public <O> Flowable<HttpResponse<O>> exchange(String uri, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}

	@Trace
	public <I, O> Flowable<HttpResponse<O>> exchange(HttpRequest<I> request, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}

	@Trace
	public <I, O> Flowable<O> retrieve(HttpRequest<I> request, Argument<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"retrieve");
		return Weaver.callOriginal();
	}

	@Trace
	public <I, O> Flowable<O> retrieve(HttpRequest<I> request, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"retrieve");
		return Weaver.callOriginal();
	}

	@Trace
	public <I> Flowable<String> retrieve(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"retrieve");
		return Weaver.callOriginal();
	}

	@Trace
	public Flowable<String> retrieve(String uri) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxHttpClient",getClass().getSimpleName(),"retrieve");
		return Weaver.callOriginal();
	}
}
