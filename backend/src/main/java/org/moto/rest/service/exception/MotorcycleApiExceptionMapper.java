package org.moto.rest.service.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Provider  // Register the mapper as a provider for JAX-RS
public class MotorcycleApiExceptionMapper implements ExceptionMapper<MotorcycleApiException> {

    @Override
    public Response toResponse(MotorcycleApiException exception) {
        log.error("Error occurred: {}", exception.getMessage(), exception);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Map.of(
                        "error", exception.getMessage(),
                        "code", exception.getErrorCode(),
                        "details", exception.getDetails(),
                        "type", categorizeError(exception)
                ))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private String categorizeError(MotorcycleApiException exception) {
        return switch (exception.getErrorCode()) {
            case "CLIENT_ERROR" -> "Client-side Error";
            case "SERVER_ERROR" -> "Server-side Error";
            default -> "Unknown Error";
        };
    }

}
