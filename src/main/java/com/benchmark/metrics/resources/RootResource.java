package com.benchmark.metrics.resources;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.benchmark.metrics.pages.ProviderSelectPage;
import com.benchmark.metrics.postgres.DatabaseService;
import com.benchmark.metrics.pages.DisplayDataPage;

/**
 * @author jsanderson
 */
@Path("/root")
public class RootResource {

    private final DatabaseService dataFetchService;

    @Inject
    public RootResource(DatabaseService dataFetchService) {
        this.dataFetchService = dataFetchService;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response doGet() throws SQLException {
        return Response.ok(new ProviderSelectPage()).build();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response doPost(@FormParam(ProviderSelectPage.PROVIDER_INPUT) String providerNumber) throws SQLException {
        dataFetchService.getProviderInfo()
        try {
            return Response.ok(new DisplayDataPage(dataFetchService.getData(Integer.valueOf(providerNumber)))).build();
        } catch(NumberFormatException e) {
            return Response.ok(new ProviderSelectPage()).build();
        }
    }

}
