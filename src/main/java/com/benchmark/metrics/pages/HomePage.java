package com.benchmark.metrics.pages;

import static com.benchmark.metrics.jaxrs.TextMapper.getText;

import javax.ws.rs.core.UriInfo;

import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson .
 */
public class HomePage extends BasePage{
    public HomePage(UriInfo uriInfo) {
        super(uriInfo);
        createBody();
    }

    public void createBody() {
        body.appendChild(
                new H1().appendText(getText(Content.HEADER)),
                new P().appendText(getText(Content.WELCOME)),
                new A().appendText(getText(Content.SEARCH_LINK)).setHref(uriInfo.getBaseUri().getPath() + "search")
        );
    }

    @Override
    public String getPageTitle() {
        return getText(Content.TITLE);
    }

    public enum Content implements TextKey {
        TITLE, HEADER, WELCOME, SEARCH_LINK;
    }
}
