package com.benchmark.metrics.pages;

import static com.benchmark.metrics.jaxrs.TextMapper.getText;
import static com.benchmark.metrics.pages.ProviderInfoPage.Content.HEALTH_INSPECTION;
import static com.benchmark.metrics.pages.ProviderInfoPage.Content.KEY_PERFORMANCE_INDICATORS;
import static com.benchmark.metrics.pages.ProviderInfoPage.Content.OVERALL;
import static com.benchmark.metrics.pages.ProviderInfoPage.Content.QM_RATING;
import static com.benchmark.metrics.pages.ProviderInfoPage.Content.RATING_SUMMARY;
import static com.benchmark.metrics.pages.ProviderInfoPage.Content.RN_STAFFING_RATING;
import static com.benchmark.metrics.pages.ProviderInfoPage.Content.STAFFING_METRICS;
import static com.benchmark.metrics.pages.ProviderInfoPage.Content.STAFFING_RATING;

import javax.ws.rs.core.UriInfo;

import com.benchmark.metrics.data.ProviderInfo;
import com.benchmark.metrics.data.StateAverage;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.H2;
import com.hp.gagawa.java.elements.H3;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Th;
import com.hp.gagawa.java.elements.Tr;
import com.hp.gagawa.java.elements.Ul;

/**
 * @author jsanderson
 */
public class ProviderInfoPage extends BasePage {

    private final ProviderInfo providerInfo;
    private final StateAverage stateAverage;
    private final StateAverage nationalAverage;

    public ProviderInfoPage(UriInfo uriInfo, ProviderInfo providerInfo, StateAverage stateAverage, StateAverage nationalAverage) {
        super(uriInfo);
        this.providerInfo = providerInfo;
        this.stateAverage = stateAverage;
        this.nationalAverage = nationalAverage;
        createBody();
    }

    private void createBody() {
        body.appendChild(
                getProviderNameAndAddress(),
                getBasicProviderInfo(),
                new H2().appendText(getText(KEY_PERFORMANCE_INDICATORS)),
                getProviderRatingList(),
                getProviderInfoComparisonTable()
        );
    }

    private Node getProviderNameAndAddress() {
        return new Div().appendChild(
            new H1().appendText(providerInfo.getPrettyProviderName()),
            new H2().appendText(providerInfo.getAddress())
        );
    }

    private Node getBasicProviderInfo() {
        return new Table().appendChild(
                new Tr().appendChild(
                        new Th().appendText(getText(Content.PROVIDER_NUMBER)),
                        new Th().appendText(getText(Content.PHONE)),
                        new Th().appendText(getText(Content.OWNERSHIP_TYPE)),
                        new Th().appendText(getText(Content.PROVIDER_TYPE)),
                        new Th().appendText(getText(Content.CURRENT_OCCUPATION))
                ),
                new Tr().appendChild(
                        new Td().appendText(providerInfo.getProviderNumber()),
                        new Td().appendText(providerInfo.getPhoneNumber()),
                        new Td().appendText(providerInfo.getOwnershipType().getType()),
                        new Td().appendText(providerInfo.getProviderType().getType()),
                        new Td().appendText(providerInfo.getOccupiedBedPctString() + "%")
                )
        );
    }

    private Node getProviderRatingList() {
        return new Div().appendChild(
                new H3().appendText(getText(RATING_SUMMARY)),
                new Ul().appendChild(
                        new Li().appendText(getText(OVERALL, providerInfo.getOverallRating().getValue())),
                        new Li().appendText(getText(HEALTH_INSPECTION, providerInfo.getHealthInspectionRating().getValue())),
                        new Li().appendText(getText(QM_RATING, providerInfo.getQualityRating().getValue())),
                        new Li().appendText(getText(STAFFING_RATING, providerInfo.getStaffingRating().getValue())),
                        new Li().appendText(getText(RN_STAFFING_RATING, providerInfo.getRnStaffingRating().getValue()))
                )
        );
    }

    private Node getProviderInfoComparisonTable() {
        return new Div().appendChild(
                new H3().appendText(getText(STAFFING_METRICS)),
                new Table().appendChild(
                        new Tr().appendChild(
                                new Th().appendText(getText(Content.NAME)),
                                new Th().appendText(getText(Content.CNA_STAFFING_HOURS)),
                                new Th().appendText(getText(Content.LPN_STAFFING_HOURS)),
                                new Th().appendText(getText(Content.RN_STAFFING_HOURS)),
                                new Th().appendText(getText(Content.LICENSED_STAFFING_HOURS)),
                                new Th().appendText(getText(Content.TOTAL_NURSE_STAFFING_HOURS))
                        ),
                        new Tr().appendChild(
                                new Td().appendText(providerInfo.getPrettyProviderName()),
                                new Td().appendText(providerInfo.getCnaStaffingHours().toString()),
                                new Td().appendText(providerInfo.getLpnStaffingHours().toString()),
                                new Td().appendText(providerInfo.getRnStaffingHours().toString()),
                                new Td().appendText(providerInfo.getLicenscedStaffingHours().toString()),
                                new Td().appendText(providerInfo.getTotalNurseStaffingHours().toString())
                        ),
                        new Tr().appendChild(
                                new Td().appendText(stateAverage.getState().toString()),
                                new Td().appendText(stateAverage.getCnaStaffingHours().toString()),
                                new Td().appendText(stateAverage.getLpnStaffingHours().toString()),
                                new Td().appendText(stateAverage.getRnStaffingHours().toString()),
                                new Td().appendText(stateAverage.getLicenscedStaffingHours().toString()),
                                new Td().appendText(stateAverage.getTotalNurseStaffingHours().toString())
                        ),
                        new Tr().appendChild(
                                new Td().appendText(nationalAverage.getState().toString()),
                                new Td().appendText(nationalAverage.getCnaStaffingHours().toString()),
                                new Td().appendText(nationalAverage.getLpnStaffingHours().toString()),
                                new Td().appendText(nationalAverage.getRnStaffingHours().toString()),
                                new Td().appendText(nationalAverage.getLicenscedStaffingHours().toString()),
                                new Td().appendText(nationalAverage.getTotalNurseStaffingHours().toString())
                        )
                )
        );
    }

    @Override
    public String getPageTitle() {
        return getText(Content.TITLE);
    }

    public enum Content implements TextKey {
        TITLE, NAME, KEY_PERFORMANCE_INDICATORS, STAFFING_METRICS, CNA_STAFFING_HOURS, LPN_STAFFING_HOURS, RN_STAFFING_HOURS, LICENSED_STAFFING_HOURS, TOTAL_NURSE_STAFFING_HOURS,
        PROVIDER_NUMBER, PHONE, OWNERSHIP_TYPE, PROVIDER_TYPE, CURRENT_OCCUPATION, RATING_SUMMARY, OVERALL, HEALTH_INSPECTION, QM_RATING, STAFFING_RATING, RN_STAFFING_RATING;
    }
}