package com.benchmark.metrics.pages;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Br;
import com.hp.gagawa.java.elements.Fieldset;
import com.hp.gagawa.java.elements.Form;
import com.hp.gagawa.java.elements.Input;
import com.hp.gagawa.java.elements.Label;
import com.hp.gagawa.java.elements.P;
import com.hp.gagawa.java.elements.Text;

/**
 * @author jsanderson
 */
public class ProviderSearchPage extends Document {

    public static final String PROVIDER_INPUT = "providerInput";

    public ProviderSearchPage() {
        this(null);
    }

    public ProviderSearchPage(String message) {
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
                                new Text("Search by provider name"),
                                new Label().appendText("Provider Name"),
                                new Input().setId(PROVIDER_INPUT).setName(PROVIDER_INPUT),
                                new Br(),
                                new Input().setType("submit").setValue("Submit")
                        )
                )
        );
    }
}