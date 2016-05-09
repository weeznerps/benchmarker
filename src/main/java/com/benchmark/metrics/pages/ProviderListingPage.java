package com.benchmark.metrics.pages;

import java.util.Collection;

import com.benchmark.metrics.data.ProviderInfo;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Ul;

/**
 * @author jsanderson
 */
public class ProviderListingPage extends BasePage {

    private final Collection<ProviderInfo> providerInfoCollection;

    public ProviderListingPage(Collection<ProviderInfo> providerInfoCollection) {
        super(DocumentType.HTMLStrict);
        this.providerInfoCollection = providerInfoCollection;
        createBody();
    }

    public void createBody() {
        body.appendChild(
                getProviderList()
        );
    }

    public Node getProviderList() {
        Ul ul = new Ul();
        providerInfoCollection.forEach(providerInfo -> {
            ul.appendChild(
                    new Li().appendChild(
                            new A().setHref("./" + providerInfo.getProviderNumber()).appendText(providerInfo
                                    .getProviderName()
                            )
                    )
            );
        });
        return ul;
    }

    @Override
    public String getPageTitle() {
        return "Provider Listing";
    }
}
