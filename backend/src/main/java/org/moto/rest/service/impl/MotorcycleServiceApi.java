package org.moto.rest.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.moto.dto.api.*;
import org.moto.rest.service.*;
import org.moto.rest.service.exception.MotorcycleApiException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

@ApplicationScoped
public class MotorcycleServiceApi {

    @RestClient
    MakeServiceAPI makeService;

    @RestClient
    CategoryServiceApi categoryService;

    @RestClient
    ModelServiceApi modelService;

    @RestClient
    ProductionServiceApi productionService;

    @RestClient
    SpecificationServiceApi specificationServiceApi;

    @RestClient
    ImageServiceApi imageServiceApi;

    @ConfigProperty(name = "motorcycle-api.host")
    String host;

    @ConfigProperty(name = "motorcycle-api.key")
    String key;


    private <T> T handleApiCall(Supplier<T> apiCall, String message, String endpoint) {
        try {
            return apiCall.get();
        } catch (WebApplicationException e) {
            int statusCode = e.getResponse().getStatus();
            String errorType = (statusCode >= 500) ? "SERVER_ERROR" : "CLIENT_ERROR";

            throw new MotorcycleApiException(
                    String.format("%s - Endpoint: %s - Status: %d", message, endpoint, statusCode),
                    e,
                    errorType,
                    e.getMessage()
            );
        } catch (Exception e) {
            throw new MotorcycleApiException(
                    String.format("%s - Endpoint: %s", message, endpoint),
                    e,
                    "UNKNOWN_ERROR",
                    e.getMessage()
            );
        }
    }



    public List<Make> getAllMakes() {
        return handleApiCall(
                () -> makeService.getMakes(host, key), "Error fetching motorcycle makes", "/makes"
        );
    }

    public List<Category> getAllCategories() {
        return handleApiCall(
                () -> categoryService.getCategories(host, key),
                "Error fetching motorcycle categories", "/categories"
        );
    }

    public List<Model> getModelByMake(String makeName) {
        return handleApiCall(
                () -> modelService.getModelByMake(host, key, makeName),
                "Error fetching motorcycle models by make", "/makes-name/" + makeName
        );
    }

    public List<Model> getModelByMakeId(String makeId) {
        return handleApiCall(
                () -> modelService.getModelByMakeId(host, key, makeId),
                "Error fetching motorcycle models by make id", "/makes-id/" + makeId
        );
    }

    public List<Model> getModelByMakeIdAndYear(String makeId, String year) {
        return handleApiCall(
                () -> modelService.getModelByMakeIdAndYear(host, key, makeId, year),
                "Error fetching motorcycle models by make id and year", "/makes-year/" + makeId + "/" + year
        );
    }

    public List<Model> getModelByMakeIdYearCategory(String makeId, String year, String category) {
        return handleApiCall(
                () -> modelService.getModelByMakeIdYearCategory(host, key, makeId, year, category),
                "Error fetching motorcycle models by make id, year, and category", "/makes-by/" + makeId + "/" + year + "/" + category
        );
    }

    public List<Model> getModelByMakeIdAndCategory(String makeId, String category) {
        return handleApiCall(
                () -> modelService.getModelByMakeIdAndCategory(host, key, makeId, category),
                "Error fetching motorcycle models by make id and category", "/makes-category/" + makeId + "/" + category
        );
    }

    public List<Production> getProductionByModel(String modelId) {
        return handleApiCall(
                () -> productionService.getProductionByModel(host, key, modelId),
                "Error fetching motorcycle production by model", "/model/" + modelId + "/years"
        );
    }

    public List<Production> getProductionByGroupedModel(String groupedId) {
        return handleApiCall(
                () -> productionService.getProductionByGroupedModel(host, key, groupedId),
                "Error fetching motorcycle production by grouped model", "/grouped-models/" + groupedId + "/grouped-models-years"
        );
    }

    public List<Specification> getSpecificationByArticle(String articleId) {
        return handleApiCall(
                () -> specificationServiceApi.getSpecificationByArticle(host, key, articleId),
                "Error fetching motorcycle specification by article", "/article/" + articleId
        );
    }

    public byte[] getImageByArticleId(String articleId) {
        return handleApiCall(
                () -> {
                    byte[] image = imageServiceApi.getImageByArticleId(host, key, articleId);
                    try (FileOutputStream fos = new FileOutputStream("image.jpg")) {
                        fos.write(image);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return image;
                },
                "Error fetching motorcycle image by article id", "/article/" + articleId + "/image/media"
        );
    }

    public List<Image> getImageByImageId(String imageId) {
        return handleApiCall(
                () -> imageServiceApi.getImageByImageId(host, key, imageId),
                "Error fetching motorcycle image by image id", "/article/" + imageId + "/image/link"
        );
    }
}
