package com.benchmark.metrics.pages;

import static com.benchmark.metrics.jaxrs.TextMapper.getText;

import javax.ws.rs.core.UriInfo;

import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson
 */
public class ServerErrorPage extends BasePage {

    private final Exception exception;

    public ServerErrorPage(UriInfo uriInfo, Exception exception) {
        super(uriInfo);
        this.exception = exception;
        createBody();
    }

    private void createBody() {
        body.appendChild(new P().appendText(getText(Content.MESSAGE, exception.getMessage())));
    }

    @Override
    public String getPageTitle() {
        return getText(Content.TITLE);
    }

    public enum Content implements TextKey {
        TITLE, MESSAGE;
    }
}
