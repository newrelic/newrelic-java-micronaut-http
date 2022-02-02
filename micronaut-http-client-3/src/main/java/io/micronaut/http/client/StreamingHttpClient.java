package io.micronaut.http.client;

import java.util.Map;

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

@Weave(type = MatchType.Interface)
public abstract class StreamingHttpClient {

	@Trace
	public <I> Publisher<ByteBuffer<?>> dataStream(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","StreamingHttpClient",getClass().getSimpleName(),"dataStream");
        return Weaver.callOriginal();
    }

	@Trace
    public <I> Publisher<HttpResponse<ByteBuffer<?>>> exchangeStream(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","StreamingHttpClient",getClass().getSimpleName(),"exchangeStream");
        return Weaver.callOriginal();
    }

	@Trace
    public <I> Publisher<Map<String, Object>> jsonStream(HttpRequest<I> request) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","StreamingHttpClient",getClass().getSimpleName(),"jsonStream");
        return Weaver.callOriginal();
    }

	@Trace
    public <I, O> Publisher<O> jsonStream(HttpRequest<I> request, Argument<O> type) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","StreamingHttpClient",getClass().getSimpleName(),"jsonStream");
        return Weaver.callOriginal();
    }

	@Trace
    public <I, O> Publisher<O> jsonStream(HttpRequest<I> request, Class<O> type) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Micronaut","StreamingHttpClient",getClass().getSimpleName(),"jsonStream");
        return Weaver.callOriginal();
    }

}
