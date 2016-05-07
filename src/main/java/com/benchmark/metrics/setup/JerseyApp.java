package com.benchmark.metrics.setup;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author jsanderson
 */
@ApplicationPath("/")
public class JerseyApp extends ResourceConfig {
    @Inject
    public JerseyApp(ServiceLocator serivceLocator) {
        ServiceLocatorUtilities.enableImmediateScope(serivceLocator);
        packages(false, "com.benchmark.metrics.jaxrs");
        packages(false, "com.benchmark.metrics.resources");
        register(new DependencyBinder());
    }
}
