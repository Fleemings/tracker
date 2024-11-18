package org.moto.rest.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.moto.dto.api.Category;

import java.util.List;
@RegisterRestClient(configKey = "motorcycle-api")
public interface CategoryServiceApi {

    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON)
    List<Category> getCategories(@HeaderParam("x-rapidapi-host" ) String host,
                                 @HeaderParam("x-rapidapi-key") String key);


}
