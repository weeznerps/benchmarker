package com.benchmark.metrics.resources;


import static com.benchmark.metrics.resources.ProviderNameSearchResource.PROVIDER_SEARCH_PATH_PARAM;

import java.sql.SQLException;
import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.benchmark.metrics.data.ProviderInfo;
import com.benchmark.metrics.pages.ProviderListingPage;
import com.benchmark.metrics.pages.ProviderSearchPage;
import com.benchmark.metrics.postgres.DatabaseService;

/**
 * @author jsanderson
 */
@Path("/search/{" + PROVIDER_SEARCH_PATH_PARAM + "}")
public class ProviderNameSearchResource {

    public static final String PROVIDER_SEARCH_PATH_PARAM = "providerName";

    private final DatabaseService databaseService;

    @Inject
    public ProviderNameSearchResource(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response doGet(@PathParam(PROVIDER_SEARCH_PATH_PARAM) String search) throws SQLException {
        return doPost(search);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response doPost(@PathParam(PROVIDER_SEARCH_PATH_PARAM) String search) throws SQLException {
        Collection<ProviderInfo> providers = databaseService.searchProviderInfoByName(search);
        if(providers.isEmpty()) {
            return Response.ok(new ProviderSearchPage("No results")).build();
        }
        return Response.ok(new ProviderListingPage(providers)).build();
    }

}
