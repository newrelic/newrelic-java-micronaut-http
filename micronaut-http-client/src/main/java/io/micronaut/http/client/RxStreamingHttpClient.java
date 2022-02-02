package io.micronaut.http.client;

import java.util.Map;

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

@Weave(type = MatchType.Interface)
public abstract class RxStreamingHttpClient {

    @Trace
    public <I> Flowable<ByteBuffer<?>> dataStream(HttpRequest<I> request) {
    	NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxStreamingHttpClient",getClass().getSimpleName(),"dataStream");
    	return Weaver.callOriginal();
    }

    @Trace
    public <I> Flowable<HttpResponse<ByteBuffer<?>>> exchangeStream(HttpRequest<I> request){
    	NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxStreamingHttpClient",getClass().getSimpleName(),"exchangeStream");
    	return Weaver.callOriginal();
    }

    @Trace
    public <I> Flowable<Map<String, Object>> jsonStream(HttpRequest<I> request){
    	NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxStreamingHttpClient",getClass().getSimpleName(),"jsonStream");
    	return Weaver.callOriginal();
    }

    @Trace
    public <I, O> Flowable<O> jsonStream(HttpRequest<I> request, Argument<O> type) {
    	NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxStreamingHttpClient",getClass().getSimpleName(),"jsonStream");
    	return Weaver.callOriginal();
    }

    @Trace
    public <I, O> Flowable<O> jsonStream(HttpRequest<I> request, Class<O> type) {
    	NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxStreamingHttpClient",getClass().getSimpleName(),"jsonStream");
        return Weaver.callOriginal();
    }

}
