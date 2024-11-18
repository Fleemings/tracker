package org.moto.rest.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.moto.dto.api.Image;

import java.util.List;

@RegisterRestClient(configKey = "motorcycle-api")
public interface ImageServiceApi {

    @GET
    @Path("article/{articleId}/image/media")
    byte[] getImageByArticleId(@HeaderParam("x-rapidapi-host" ) String host,
                               @HeaderParam("x-rapidapi-key") String key, @PathParam("articleId") String articleId);

    @GET
    @Path("article/{articleId}/image/link")
    List<Image> getImageByImageId(@HeaderParam("x-rapidapi-host" ) String host,
                                    @HeaderParam("x-rapidapi-key") String key, @PathParam("articleId") String imageId);

}
