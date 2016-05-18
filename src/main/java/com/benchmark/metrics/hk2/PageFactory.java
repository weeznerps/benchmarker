package com.benchmark.metrics.hk2;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.core.UriInfo;

import com.benchmark.metrics.data.ProviderInfo;
import com.benchmark.metrics.data.StateAverage;
import com.benchmark.metrics.pages.HomePage;
import com.benchmark.metrics.pages.NotFoundPage;
import com.benchmark.metrics.pages.ProviderInfoPage;
import com.benchmark.metrics.pages.ProviderSearchPage;
import com.benchmark.metrics.pages.ServerErrorPage;

/**
 * @author jsanderson
 */
public class PageFactory {

    private final Provider<UriInfo> uriInfoProvider;

    @Inject
    public PageFactory(Provider<UriInfo> uriInfoProvider) {
        this.uriInfoProvider = uriInfoProvider;
    }

    public HomePage getHomePage() {
        return new HomePage(uriInfoProvider.get());
    }

    public ProviderInfoPage getProviderInfoPage(ProviderInfo providerInfo, StateAverage stateAverage, StateAverage nationalAverage) {
        return new ProviderInfoPage(uriInfoProvider.get(), providerInfo, stateAverage, nationalAverage);
    }


    public ProviderSearchPage getProviderSearchPage() {
        return new ProviderSearchPage(uriInfoProvider.get());
    }

    public ProviderSearchPage getProviderSearchPage(Collection<ProviderInfo> results) {
        return new ProviderSearchPage(uriInfoProvider.get(), results, results.isEmpty());
    }

    public NotFoundPage getNotFoundPage() {
        return new NotFoundPage(uriInfoProvider.get());
    }

    public ServerErrorPage getServerErrorPage(Exception exception) {
        return new ServerErrorPage(uriInfoProvider.get(), exception);
    }
}
