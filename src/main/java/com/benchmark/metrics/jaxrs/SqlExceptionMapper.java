package com.benchmark.metrics.jaxrs;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.benchmark.metrics.hk2.PageFactory;

/**
 * @author jsanderson .
 */
@Provider
public class SqlExceptionMapper implements ExceptionMapper<SQLException> {

    private PageFactory pageFactory;
    @Inject
    public SqlExceptionMapper(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }

    @Override
    public Response toResponse(SQLException exception) {
        return Response.serverError().entity(pageFactory.getServerErrorPage(exception)).build();
    }
}
