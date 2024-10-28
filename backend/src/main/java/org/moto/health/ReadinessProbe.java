package org.moto.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class ReadinessProbe implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        // future possibility to access the repository: .withData( repo.getmethodo).build()
        return HealthCheckResponse.up("ready for traffic");
    }
}
