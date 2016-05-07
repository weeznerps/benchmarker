package com.benchmark.metrics.jaxrs;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collections;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import com.hp.gagawa.java.Document;

/**
 * @author jsanderson
 */
@javax.ws.rs.ext.Provider
@Produces({"text/html"})
public class HtmlWriter implements MessageBodyWriter<Document> {

    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Document.class.isAssignableFrom(type);
    }

    public long getSize(Document document, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    public void writeTo(Document document, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, java.lang.Object> headers, OutputStream outputStream) throws
            IOException, WebApplicationException {
        headers.put(HttpHeaders.CONTENT_TYPE, Collections.<Object>singletonList("text/html;charset=UTF8"));
        Writer writer = new OutputStreamWriter(outputStream, Charset.forName("utf-8"));
        writer.write(document.write());
        writer.flush();
    }

}
