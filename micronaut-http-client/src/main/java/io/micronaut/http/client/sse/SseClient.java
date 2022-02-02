package io.micronaut.http.client.sse;

import org.reactivestreams.Publisher;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.sse.Event;

@Weave(type = MatchType.Interface)
public abstract class SseClient {

	@Trace
    public <I> Publisher<Event<ByteBuffer<?>>> eventStream(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","SseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }

	@Trace
    public <I, B> Publisher<Event<B>> eventStream(HttpRequest<I> request, Argument<B> eventType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","SseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }


	@Trace
    public <I, B> Publisher<Event<B>> eventStream(HttpRequest<I> request, Class<B> eventType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","SseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }

	@Trace
    public <B> Publisher<Event<B>> eventStream(String uri, Class<B> eventType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","SseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }

    public <B> Publisher<Event<B>> eventStream(String uri, Argument<B> eventType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","SseClient",getClass().getSimpleName(),"eventStream");
        return Weaver.callOriginal();
    }
}
