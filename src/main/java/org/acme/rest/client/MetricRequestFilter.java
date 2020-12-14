package org.acme.rest.client;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class MetricRequestFilter implements ContainerRequestFilter {
	public final static String REQUEST_TIMER_SAMPLE_PROPERTY = "timerSample";

	@Inject
	MeterRegistry registry;

	@Override
	public void filter(ContainerRequestContext context) {
		context.setProperty(REQUEST_TIMER_SAMPLE_PROPERTY, Timer.start(registry));
	}
}
