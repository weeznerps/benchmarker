package com.benchmark.metrics.pages;

import static com.benchmark.metrics.jaxrs.TextMapper.getText;

import javax.ws.rs.core.UriInfo;

import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson
 */
public class NotFoundPage extends BasePage {

    public NotFoundPage(UriInfo uriInfo) {
        super(uriInfo);
        createBody();
    }

    public void createBody() {
        body.appendChild(new P().appendText(getText(Content.MESSAGE)));
    }

    @Override
    public String getPageTitle() {
        return getText(Content.TITLE);
    }

    public enum Content implements TextKey {
        TITLE, MESSAGE;
    }
}
