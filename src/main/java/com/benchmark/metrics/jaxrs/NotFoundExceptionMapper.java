package com.benchmark.metrics.jaxrs;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.benchmark.metrics.pages.NotFoundPage;

/**
 * @author jsanderson
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    public Response toResponse(NotFoundException e) {
        return Response.status(e.getResponse().getStatus()).entity(new NotFoundPage()).build();
    }
}
