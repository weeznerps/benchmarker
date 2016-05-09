package com.benchmark.metrics.pages;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Meta;
import com.hp.gagawa.java.elements.Title;

/**
 * @author jsanderson
 */
public abstract class BasePage extends Document {

    public BasePage(DocumentType spec) {
        super(spec);
        createHead();
    }

    public void createHead() {
        Meta content = new Meta("text/html;charset=utf-8");
        content.setAttribute("http-equiv","content-type");
        head.appendChild(
                new Title().appendText(getPageTitle()),
                content
        );
    }

    public abstract String getPageTitle();

}
