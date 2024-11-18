package org.moto.rest.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.moto.dto.api.Production;

import java.util.List;

@RegisterRestClient(configKey = "motorcycle-api")
public interface ProductionServiceApi {

    @GET
    @Path("/model/{modelId}/years")
    @Produces(MediaType.APPLICATION_JSON)
    List<Production> getProductionByModel(@HeaderParam("x-rapidapi-host" ) String host,
                                          @HeaderParam("x-rapidapi-key") String key, String modelId);

    @GET
    @Path("/model/{groupedId}/grouped-models-years")
    @Produces(MediaType.APPLICATION_JSON)
    List<Production> getProductionByGroupedModel(@HeaderParam("x-rapidapi-host" ) String host,
                                                 @HeaderParam("x-rapidapi-key") String key, String groupedId);
}
