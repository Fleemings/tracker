package org.moto.controller;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.jboss.logging.Logger;
import org.moto.dto.api.*;
import org.moto.rest.service.impl.MotorcycleServiceApi;

import java.util.List;

@ApplicationScoped
@Path("/motorcycle")
@Produces("application/json")
public class MotorcycleAPIController {

    @Inject
    MotorcycleServiceApi motorcycleService;

    private final static Logger logger = Logger.getLogger(MotorcycleAPIController.class);

    @GET
    @Path("/makes")
    public List<Make> getMakes() {
        logger.info("Getting all makes");
        return motorcycleService.getAllMakes();
    }

    @GET
    @Path("/categories")
    public List<Category> getCategories() {
        logger.info("Getting all categories");
        return motorcycleService.getAllCategories();
    }

    @GET
    @Path("/makes-name/{makeName}")
    public List<Model> getModelByMake(String makeName) {
        logger.info("Getting model by make name");
        return motorcycleService.getModelByMake(makeName);
    }

    @GET
    @Path("/makes-id/{makeId}")
    public List<Model> getModelByMakeId(String makeId) {
        logger.info("Getting model by make id");
        return motorcycleService.getModelByMakeId(makeId);
    }

    @GET
    @Path("/makes-year/{makeId}/{year}")
    public List<Model> getModelByMakeIdAndYear(String makeId, String year) {
        logger.info("Getting model by make id and year");
        return motorcycleService.getModelByMakeIdAndYear(makeId, year);
    }

    @GET
    @Path("/makes-by/{makeId}/{year}/{category}")
    public List<Model> getModelByMakeIdYearCategory(String makeId, String year, String category) {
        logger.info("Getting model by make id, year, and category");
        return motorcycleService.getModelByMakeIdYearCategory(makeId, year, category);
    }

    @GET
    @Path("/makes-category/{makeId}/{category}")
    public List<Model> getModelByMakeIdAndCategory(String makeId, String category) {
        logger.info("Getting model by make id and category");
        return motorcycleService.getModelByMakeIdAndCategory(makeId, category);
    }

    @GET
    @Path("/model/{makeId}/years")
    public List<Production> getProductionByModel(String makeId) {
        logger.info("Getting model years by make id");
        return motorcycleService.getProductionByModel(makeId);
    }

    @GET
    @Path("/grouped-models/{groupedId}/grouped-models-years")
    public List<Production> getProductionByGroupedModel(String groupedId) {
        logger.info("Getting model years by grouped model id");
        return motorcycleService.getProductionByGroupedModel(groupedId);
    }

    @GET
    @Path("/article/{articleId}")
    public List<Specification> getSpecificationByArticle(String articleId) {
        logger.info("Getting specification by article id");
        return motorcycleService.getSpecificationByArticle(articleId);
    }

    @GET
    @Path("/article/{articleId}/image/media")
    public byte[] getImageByArticleId(String articleId) {
        logger.info("Getting image by article id");
        return motorcycleService.getImageByArticleId(articleId);
    }

    @GET
    @Path("/article/{articleId}/image/link")
    public List<Image> getImageByImageId(String articleId) {
        logger.info("Getting image by image id");
        return motorcycleService.getImageByImageId(articleId);
    }

}
