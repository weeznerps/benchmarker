package com.benchmark.metrics.pages;

import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson
 */
public class NotFoundPage extends BasePage {

    public NotFoundPage() {
        super(DocumentType.HTMLStrict);
        createBody();
    }

    public void createBody() {
        body.appendChild(new P().appendText("Oh no! Not found!"));
    }

    @Override
    public String getPageTitle() {
        return "Not Found";
    }
}
