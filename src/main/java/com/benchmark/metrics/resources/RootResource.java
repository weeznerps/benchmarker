package com.benchmark.metrics.resources;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.benchmark.metrics.hk2.PageFactory;

/**
 * @author jsanderson
 */
@Singleton
@Path("/")
public class RootResource {

    private final PageFactory pageFactory;
    @Inject
    public RootResource(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response doGetRoot() throws SQLException {
        return Response.ok(pageFactory.getHomePage()).build();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response doPostRoot() throws SQLException {
        return Response.ok(pageFactory.getHomePage()).build();
    }
}
