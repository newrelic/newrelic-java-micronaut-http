package com.nrlabs.test.micronaut.http;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.newrelic.agent.introspec.InstrumentationTestConfig;
import com.newrelic.agent.introspec.InstrumentationTestRunner;

@RunWith(InstrumentationTestRunner.class)
@InstrumentationTestConfig(includePrefixes = { "io.micronaut" })
public class HttpTest {

	@BeforeClass
	public static void beforeClass() {
		Application.main(null);
	}
}
