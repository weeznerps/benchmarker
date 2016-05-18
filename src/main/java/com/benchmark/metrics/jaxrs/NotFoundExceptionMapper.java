package com.benchmark.metrics.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.benchmark.metrics.hk2.PageFactory;

/**
 * @author jsanderson
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    private PageFactory pageFactory;
    @Inject
    public NotFoundExceptionMapper(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }
    public Response toResponse(NotFoundException e) {
        return Response.status(e.getResponse().getStatus()).entity(pageFactory.getNotFoundPage()).build();
    }
}
