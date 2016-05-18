package com.benchmark.metrics.pages;

import static com.benchmark.metrics.jaxrs.TextMapper.getText;
import static com.benchmark.metrics.pages.ProviderSearchPage.Content.NO_RESULTS;

import java.util.Collection;
import java.util.Collections;

import javax.ws.rs.core.UriInfo;

import com.benchmark.metrics.data.ProviderInfo;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Br;
import com.hp.gagawa.java.elements.Fieldset;
import com.hp.gagawa.java.elements.Form;
import com.hp.gagawa.java.elements.Input;
import com.hp.gagawa.java.elements.Label;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.P;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Ul;

/**
 * @author jsanderson
 */
public class ProviderSearchPage extends BasePage {

    public static final String PROVIDER_INPUT = "providerInput";

    private final Collection<ProviderInfo> providerInfoCollection;
    private final boolean noResults;


    public ProviderSearchPage(UriInfo uriInfo) {
        this(uriInfo, Collections.emptyList(), false);
    }

    public ProviderSearchPage(UriInfo uriInfo, Collection<ProviderInfo> providerInfoCollection, boolean noResults) {
        super(uriInfo);
        this.providerInfoCollection = providerInfoCollection;
        this.noResults = noResults;
        createBody();
    }

    private void createBody() {
        if(noResults) {
            body.appendChild(new P().appendText(getText(NO_RESULTS)));
        }

        body.appendChild(
                new Form(uriInfo.getBaseUri().getPath() + "search").setMethod("post").appendChild(
                        new Fieldset().appendChild(
                                new Text(getText(Content.MESSAGE)),
                                new Label().appendText(getText(Content.PROVIDER_NAME)),
                                new Input().setId(PROVIDER_INPUT).setName(PROVIDER_INPUT),
                                new Br(),
                                new Input().setType("submit").setValue(getText(Content.SUBMIT)),
                                getProviderList()
                        )
                )
        );
    }

    private Node getProviderList() {
        Ul ul = new Ul();
        providerInfoCollection.forEach(providerInfo -> {
            ul.appendChild(
                    new Li().appendChild(
                            new A().setHref(uriInfo.getBaseUri().getPath() + "provider/" + providerInfo
                                    .getProviderNumber()).appendText(providerInfo
                                    .getPrettyProviderName()
                            )
                    )
            );
        });
        return ul;
    }

    @Override
    public String getPageTitle() {
        return getText(Content.TITLE);
    }

    public enum Content implements TextKey {
        TITLE, MESSAGE, PROVIDER_NAME, SUBMIT, NO_RESULTS;
    }
}