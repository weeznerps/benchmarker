package com.benchmark.metrics.resources;


import java.sql.SQLException;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.benchmark.metrics.data.ProviderInfo;
import com.benchmark.metrics.data.StateAverage;
import com.benchmark.metrics.pages.ProviderInfoComparePage;
import com.benchmark.metrics.pages.ProviderSelectPage;
import com.benchmark.metrics.postgres.DatabaseService;

/**
 * @author jsanderson
 */
@Path("/root")
public class RootResource {

    private final DatabaseService databaseService;

    @Inject
    public RootResource(DatabaseService dataFetchService) {
        this.databaseService = dataFetchService;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response doGet() throws SQLException {
        return Response.ok(new ProviderSelectPage()).build();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response doPost(@FormParam(ProviderSelectPage.PROVIDER_INPUT) String providerNumber) throws SQLException {
        Optional<ProviderInfo> providerInfoOptional = databaseService.getProviderInfo(providerNumber);
        if(providerInfoOptional.isPresent()) {
            ProviderInfo providerInfo = providerInfoOptional.get();
            StateAverage stateAverage = databaseService.getStateAverage(providerInfo.getState());
            StateAverage nationalAverage = databaseService.getNationAverage();
            return Response.ok(new ProviderInfoComparePage(providerInfo, stateAverage, nationalAverage)).build();

        } else {
            return Response.ok(new ProviderSelectPage("No provider found")).build();

        }
    }

}
