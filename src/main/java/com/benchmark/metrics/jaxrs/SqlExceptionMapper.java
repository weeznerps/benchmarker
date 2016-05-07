package com.benchmark.metrics.jaxrs;

import java.sql.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.benchmark.metrics.pages.ServerErrorPage;

/**
 * @author jsanderson .
 */
@Provider
public class SqlExceptionMapper implements ExceptionMapper<SQLException> {
    @Override
    public Response toResponse(SQLException exception) {
        return Response.serverError().entity(new ServerErrorPage(exception)).build();
    }
}
