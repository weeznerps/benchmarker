package com.benchmark.metrics.pages;

import javax.ws.rs.core.UriInfo;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Meta;
import com.hp.gagawa.java.elements.Title;

/**
 * @author jsanderson
 */
public abstract class BasePage extends Document {

    protected final UriInfo uriInfo;

    public BasePage(UriInfo uriInfo) {
        super(DocumentType.HTMLStrict);
        this.uriInfo = uriInfo;
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
