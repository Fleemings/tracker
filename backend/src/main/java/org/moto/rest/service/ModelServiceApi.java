package org.moto.rest.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.moto.dto.api.Model;

import java.util.List;

@RegisterRestClient(configKey = "motorcycle-api")
public interface ModelServiceApi {

    @GET
    @Path("/model/make-name/{makeName}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Model> getModelByMake(@HeaderParam("x-rapidapi-host" ) String host,
                              @HeaderParam("x-rapidapi-key") String key, String makeName);

    @GET
    @Path("/model/make-id/{makeId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Model> getModelByMakeId(@HeaderParam("x-rapidapi-host" ) String host,
                               @HeaderParam("x-rapidapi-key") String key, String makeId);

    @GET
    @Path("/model/make-id/{makeId}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Model> getModelByMakeIdAndYear(@HeaderParam("x-rapidapi-host" ) String host,
                                 @HeaderParam("x-rapidapi-key") String key, String makeId, String year);

    @GET
    @Path("/model/make-id/{makeId}/{year}/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Model> getModelByMakeIdYearCategory(@HeaderParam("x-rapidapi-host" ) String host,
                                        @HeaderParam("x-rapidapi-key") String key, String makeId, String year, String category);

    @GET
    @Path("/model/make-id/{makeId}/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Model> getModelByMakeIdAndCategory(@HeaderParam("x-rapidapi-host" ) String host,
                                             @HeaderParam("x-rapidapi-key") String key, String makeId, String category);
}
