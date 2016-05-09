package com.benchmark.metrics.resources;

import static com.benchmark.metrics.pages.ProviderSearchPage.PROVIDER_INPUT;

import java.net.URI;
import java.sql.SQLException;

import javax.inject.Singleton;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.benchmark.metrics.pages.HomePage;
import com.benchmark.metrics.pages.ProviderSearchPage;

/**
 * @author jsanderson
 */
@Singleton
@Path("/")
public class RootResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response doGetRoot() throws SQLException {
        return Response.ok(new HomePage()).build();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response doPostRoot() throws SQLException {
        return Response.ok(new HomePage()).build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.TEXT_HTML)
    public Response doGetSearch() throws SQLException {
        return Response.ok(new ProviderSearchPage()).build();
    }

    @POST
    @Path("/search")
    @Produces(MediaType.TEXT_HTML)
    public Response doPostSearch(@FormParam(PROVIDER_INPUT) String searchString) throws SQLException {
        return Response.seeOther(URI.create("./search/" + searchString)).build();
    }
}
