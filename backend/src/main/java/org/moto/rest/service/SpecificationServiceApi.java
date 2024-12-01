package org.moto.rest.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.moto.dto.api.Specification;

import java.util.List;

@RegisterRestClient(configKey = "motorcycle-api")
public interface SpecificationServiceApi {

    @GET
    @Path("/article/{articleId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Specification> getSpecificationByArticle(@HeaderParam("x-rapidapi-host" ) String host,
                                                  @HeaderParam("x-rapidapi-key") String key, String articleId);

    @GET
    @Path("article/{group}/specs/physicalMeasuresAndCapacities")
    @Produces(MediaType.APPLICATION_JSON)
    List<Specification> getPhysicalMeasuresAndCapacitiesByGroup(@HeaderParam("x-rapidapi-host" ) String host,
                                                                @HeaderParam("x-rapidapi-key") String key, String group);

}
