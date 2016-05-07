package com.benchmark.metrics.pages;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson
 */
public class HelloWorldPage extends Document {
    public HelloWorldPage() {
        super(DocumentType.HTMLStrict);
        createBody();
    }

    private void createBody() {
        body.appendChild(new P().appendText("HELLO WORLD"));
    }
}
