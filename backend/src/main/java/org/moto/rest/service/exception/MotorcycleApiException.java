package org.moto.rest.service.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MotorcycleApiException extends WebApplicationException {

    private String errorCode;
    private String details;

    public MotorcycleApiException(String message, Throwable throwable, String errorCode, String details) {
        super(message, throwable);
        this.errorCode = errorCode;
        this.details = details;
    }

    @Override
    public Response getResponse() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Map.of(
                        "error", getMessage(),
                        "code", errorCode,
                        "details", details
                ))
                .type("application/json")
                .build();
    }
}
