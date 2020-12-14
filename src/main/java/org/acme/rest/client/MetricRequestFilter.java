package org.acme.rest.client;

import java.io.IOException;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.ext.Provider;

@Provider
public class MetricRequestFilter implements ClientRequestFilter {
	public final static String REQUEST_TIMER_SAMPLE_PROPERTY = "timerSample";

	@Inject
	MeterRegistry registry;

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.setProperty(REQUEST_TIMER_SAMPLE_PROPERTY, Timer.start(registry));
	}
}
