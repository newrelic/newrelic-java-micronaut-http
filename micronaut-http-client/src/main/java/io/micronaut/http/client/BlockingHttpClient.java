package io.micronaut.http.client;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;

@Weave(type = MatchType.Interface)
public abstract class BlockingHttpClient {

	@Trace
	public <I, O> HttpResponse<O> exchange(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}
	
	@Trace
	public <I, O> HttpResponse<O> exchange(HttpRequest<I> request, Argument<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}
	
	@Trace
	public <I, O, E> HttpResponse<O> exchange(HttpRequest<I> request, Argument<O> bodyType, Argument<E> errorType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}
	
	@Trace
	public <I, O> HttpResponse<O> exchange(HttpRequest<I> request, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}
	
	@Trace
	public <O> HttpResponse<O> exchange(String uri) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"exchange");
		return Weaver.callOriginal();
	}
	
	@Trace
   public <I, O> O retrieve(HttpRequest<I> request, Argument<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public <I, O, E> O retrieve(HttpRequest<I> request, Argument<O> bodyType, Argument<E> errorType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"retrieve");
    	return Weaver.callOriginal();
    }

	@Trace
    public <I, O> O retrieve(HttpRequest<I> request, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public <I> String retrieve(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public String retrieve(String uri) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public <O> O retrieve(String uri, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public <O, E> O retrieve(String uri, Class<O> bodyType, Class<E> errorType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"retrieve");
        return Weaver.callOriginal();
    }

	@Trace
    public <O> HttpResponse<O> exchange(String uri, Class<O> bodyType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"exchange");
        return Weaver.callOriginal();
    }

	@Trace
    public <O, E> HttpResponse<O> exchange(String uri, Class<O> bodyType, Class<E> errorType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","BlockingHttpClient",getClass().getSimpleName(),"exchange");
        return Weaver.callOriginal();
    }
}
