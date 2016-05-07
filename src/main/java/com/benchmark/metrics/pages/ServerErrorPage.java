package com.benchmark.metrics.pages;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson
 */
public class ServerErrorPage extends Document {

    private final Exception exception;

    public ServerErrorPage(Exception exception) {
        super(DocumentType.HTMLStrict);
        this.exception = exception;
        createBody();
    }

    private void createBody() {
        body.appendChild(new P().appendText("Server Error: " + exception.getMessage()));
    }
}
