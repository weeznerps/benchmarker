package com.benchmark.metrics.resources;


import static com.benchmark.metrics.pages.ProviderSearchPage.PROVIDER_INPUT;
import static com.benchmark.metrics.resources.ProviderNameSearchResource.PROVIDER_SEARCH_PATH;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.benchmark.metrics.data.ProviderInfo;
import com.benchmark.metrics.hk2.PageFactory;
import com.benchmark.metrics.postgres.DatabaseService;

/**
 * @author jsanderson
 */
@Path("/" + PROVIDER_SEARCH_PATH)
public class ProviderNameSearchResource {

    public static final String PROVIDER_SEARCH_PATH = "search";
    public static final String PROVIDER_SEARCH_PATH_PARAM = "providerName";

    private final PageFactory pageFactory;
    private final Provider<UriInfo> uriInfoProvider;
    private final DatabaseService databaseService;

    @Inject
    public ProviderNameSearchResource(PageFactory pageFactory, Provider<UriInfo> uriInfoProvider, DatabaseService
            databaseService) {
        this.pageFactory = pageFactory;
        this.uriInfoProvider = uriInfoProvider;
        this.databaseService = databaseService;
    }


    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response doGet() throws SQLException,
            URISyntaxException {
            return Response.ok(pageFactory.getProviderSearchPage()).build();
    }

    @GET
    @Path("{" + PROVIDER_SEARCH_PATH_PARAM + "}")
    @Produces(MediaType.TEXT_HTML)
    public Response doGetSearch(@PathParam(PROVIDER_SEARCH_PATH_PARAM) String search) throws SQLException,
            URISyntaxException {
        return doPostSearch(search);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response doPost(@FormParam(PROVIDER_INPUT) String formSearch) throws SQLException, URISyntaxException {
        URI requestUri = uriInfoProvider.get().getRequestUri();
        URI uri = new URI(requestUri.getScheme(), requestUri.getUserInfo(), requestUri.getHost(), requestUri.getPort
                (), requestUri.getPath() + "/" + formSearch, null, null);
        return Response.seeOther(uri).build();
    }

    @POST
    @Path("{" + PROVIDER_SEARCH_PATH_PARAM + "}")
    @Produces(MediaType.TEXT_HTML)
    public Response doPostSearch(@PathParam(PROVIDER_SEARCH_PATH_PARAM)
            String searchParam) throws SQLException, URISyntaxException {
        Collection<ProviderInfo> providers = databaseService.searchProviderInfoByName(searchParam);
        return Response.ok(pageFactory.getProviderSearchPage(providers)).build();
    }
}
