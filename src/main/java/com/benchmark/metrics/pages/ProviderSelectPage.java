package com.benchmark.metrics.pages;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Input;

/**
 * @author jsanderson
 */
public class ProviderSelectPage extends Document {

    public static final String PROVIDER_INPUT = "providerInput";

    public ProviderSelectPage() {
        super(DocumentType.HTMLStrict);
        createBody();
    }

    private void createBody() {
        body.appendChild(new Input().setId(PROVIDER_INPUT).setTitle("Provider number"));
    }
}