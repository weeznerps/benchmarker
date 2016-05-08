package com.benchmark.metrics.pages;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Fieldset;
import com.hp.gagawa.java.elements.Form;
import com.hp.gagawa.java.elements.Input;
import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson
 */
public class ProviderSelectPage extends Document {

    public static final String PROVIDER_INPUT = "providerInput";

    public ProviderSelectPage() {
        this(null);
    }

    public ProviderSelectPage(String message) {
        super(DocumentType.HTMLStrict);
        if(message != null) {
            addMessage(message);
        }
        createBody();
    }

    private void addMessage(String message) {
        body.appendChild(new P().appendText(message));
    }

    private void createBody() {
        body.appendChild(
                new Form("").setMethod("post").appendChild(
                        new Fieldset().appendChild(
                                new Input().setId(PROVIDER_INPUT).setTitle("Provider number").setName(PROVIDER_INPUT),
                                new Input().setType("submit").setValue("go")
                        )
                )
        );
    }
}