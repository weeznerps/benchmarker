package com.benchmark.metrics.pages;

import com.benchmark.metrics.data.ProviderInfo;
import com.benchmark.metrics.data.StateAverage;
import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Th;
import com.hp.gagawa.java.elements.Tr;

/**
 * @author jsanderson
 */
public class ProviderInfoComparePage extends Document {

    private final ProviderInfo providerInfo;
    private final StateAverage stateAverage;
    private final StateAverage nationalAverage;

    public ProviderInfoComparePage(ProviderInfo providerInfo, StateAverage stateAverage, StateAverage nationalAverage) {
        super(DocumentType.HTMLStrict);
        this.providerInfo = providerInfo;
        this.stateAverage = stateAverage;
        this.nationalAverage = nationalAverage;
        createBody();
    }

    private void createBody() {
        body.appendChild(getProviderInfoComparisonTable());
    }

    private Node getProviderInfoComparisonTable() {
        return new Table().appendChild(
                new Tr().appendChild(
                        new Th().appendText("Name"),
                        new Th().appendText("CNA Staffing Hours"),
                        new Th().appendText("LPN Staffing Hours"),
                        new Th().appendText("RN Staffing Hours"),
                        new Th().appendText("Licensed Staffing Hours"),
                        new Th().appendText("Total Nurse Staffing Hours")
                ),
                new Tr().appendChild(
                        new Td().appendText(providerInfo.getProviderName()),
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
        );
    }
}