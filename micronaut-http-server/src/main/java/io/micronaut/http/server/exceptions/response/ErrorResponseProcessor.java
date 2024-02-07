package io.micronaut.http.server.exceptions.response;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;

@Weave(type = MatchType.Interface)
public abstract class ErrorResponseProcessor<T> {

	public MutableHttpResponse<T> processResponse(ErrorContext errorContext, MutableHttpResponse<?> baseResponse) {
		if(errorContext.hasErrors()) {
			HttpRequest<?> request = errorContext.getRequest();
			HashMap<String, Object> attributes = new HashMap<>();
			List<Error> errorList = errorContext.getErrors();
			attributes.put("NumberOfErrors", errorList.size());
			attributes.put("Request-Path", request.getPath());
			attributes.put("Request-URI", request.getUri());
			attributes.put("Request-Method", request.getMethod());
			attributes.put("Request-ServerName", request.getServerName());
			Optional<Throwable> rootCause = errorContext.getRootCause();
			if(rootCause.isPresent()) NewRelic.noticeError(rootCause.get(), attributes);
		}
		return Weaver.callOriginal();
	}
}
