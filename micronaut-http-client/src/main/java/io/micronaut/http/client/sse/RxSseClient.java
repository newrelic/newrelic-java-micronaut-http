package io.micronaut.http.client.sse;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.sse.Event;
import io.reactivex.Flowable;

@Weave(type = MatchType.Interface)
public abstract class RxSseClient {

    @Trace
    public <I> Flowable<Event<ByteBuffer<?>>> eventStream(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxSseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }

    @Trace
    public <I, B> Flowable<Event<B>> eventStream(HttpRequest<I> request, Argument<B> eventType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxSseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }

    @Trace
    public <I, B> Flowable<Event<B>> eventStream(HttpRequest<I> request, Class<B> eventType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxSseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }

    @Trace
    public <B> Flowable<Event<B>> eventStream(String uri, Class<B> eventType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxSseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }

    @Trace
    public <B> Flowable<Event<B>> eventStream(String uri, Argument<B> eventType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","RxSseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }

}
