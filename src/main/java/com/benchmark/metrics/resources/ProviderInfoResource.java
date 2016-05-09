package com.benchmark.metrics.resources;

import static com.benchmark.metrics.resources.ProviderInfoResource.PROVIDER_NUM_PATH_PARAM;

import java.sql.SQLException;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.benchmark.metrics.data.ProviderInfo;
import com.benchmark.metrics.data.StateAverage;
import com.benchmark.metrics.pages.ProviderInfoComparePage;
import com.benchmark.metrics.postgres.DatabaseService;

/**
 * @author jsanderson
 */
@Singleton
@Path("/provider/{" + PROVIDER_NUM_PATH_PARAM + "}")
public class ProviderInfoResource {

    public static final String PROVIDER_NUM_PATH_PARAM = "providerNum";

    private final DatabaseService databaseService;

    @Inject
    public ProviderInfoResource(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response doPost(@PathParam(PROVIDER_NUM_PATH_PARAM) String providerNumber) throws SQLException {
        Optional<ProviderInfo> providerInfoOptional = databaseService.getProviderInfoByNumber(providerNumber);
        if (providerInfoOptional.isPresent()) {
            ProviderInfo providerInfo = providerInfoOptional.get();
            StateAverage stateAverage = databaseService.getStateAverage(providerInfo.getState());
            StateAverage nationalAverage = databaseService.getNationAverage();
            return Response.ok(new ProviderInfoComparePage(providerInfo, stateAverage, nationalAverage)).build();
        }
        throw new NotFoundException();
    }
}