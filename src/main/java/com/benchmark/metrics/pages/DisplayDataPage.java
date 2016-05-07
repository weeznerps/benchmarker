package com.benchmark.metrics.pages;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson
 */
public class DisplayDataPage extends Document {

    private final String data;
    public DisplayDataPage(String data) {
        super(DocumentType.HTMLStrict);
        this.data = data;
        createBody();
    }

    private void createBody() {
        body.appendChild(new P().appendText(data));
    }
}
