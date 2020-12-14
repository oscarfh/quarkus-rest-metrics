/*
package org.acme.rest.client;

import java.io.IOException;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.http.Outcome;
import io.quarkus.micrometer.runtime.binder.vertx.VertxMetricsTags;
import io.vertx.core.http.HttpClientResponse;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class MetricResponseFilter implements ClientResponseFilter {
	public static final String HTTP_CLIENT_METRIC_NAME = "http.client.requests";

	@Inject
	MeterRegistry registry;

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		Timer.Sample sample = getRequestSample(requestContext);
		if (sample != null) {
			String requestPath = getRequestPath(requestContext);
			Timer.Builder builder = Timer.builder(HTTP_CLIENT_METRIC_NAME)
					.tags(Tags.of(
							Tag.of("method", requestContext.getMethod()),
							VertxMetricsTags.uri(requestPath, responseContext.getStatus()),
							Outcome.forStatus(responseContext.getStatus()).asTag(),
							VertxMetricsTags.status(responseContext.getStatus())));

			sample.stop(builder.register(registry));
		}
	}

	private String getRequestPath(ClientRequestContext requestContext) {
		return requestContext.getUri().getPath();
	}

	private Timer.Sample getRequestSample(ClientRequestContext requestContext) {
		return (Timer.Sample) requestContext.getProperty(MetricRequestFilter.REQUEST_TIMER_SAMPLE_PROPERTY);
	}
}
*/
