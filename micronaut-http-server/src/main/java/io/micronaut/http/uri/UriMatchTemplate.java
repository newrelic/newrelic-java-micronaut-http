package io.micronaut.http.uri;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
@Weave
public abstract class UriMatchTemplate {
	private final Pattern matchPattern = Weaver.callOriginal();
	@NewField
	private String thisTemplateString  = null;

	protected UriMatchTemplate(CharSequence templateString, Object... parserArguments) {
		thisTemplateString = templateString.toString();
	}

	protected UriMatchTemplate(CharSequence templateString, List<UriTemplate.PathSegment> segments, Pattern matchPattern, List<UriMatchVariable> variables) {
		thisTemplateString = templateString.toString();
	}

	public Optional<UriMatchInfo> match(String uri) {

		Optional<UriMatchInfo> result = Weaver.callOriginal();
		if (result.isPresent() && matchPattern != null) {
			NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_LOW, false, "Routing", thisTemplateString);
		}
		return result;
	}
}
