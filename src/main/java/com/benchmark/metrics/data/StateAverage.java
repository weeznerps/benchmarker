package com.benchmark.metrics.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.benchmark.metrics.data.ProviderInfo.State;

/**
 * @author jsanderson
 */
public class StateAverage {

    public static final int STATE_COLUMN = 1;
    public static final int CNA_STAFFING_HOURS_COLUMN = 8;
    public static final int LPN_STAFFING_HOURS_COLUMN = 9;
    public static final int RN_STAFFING_HOURS_COLUMN = 10;
    public static final int LICENCSED_STAFFING_HOURS_COLUMN = 11;
    public static final int TOTAL_NURSE_STAFFLING_HOURS_COLUMN = 12;

    private final State state;
    private final Double cnaStaffingHours;
    private final Double lpnStaffingHours;
    private final Double rnStaffingHours;
    private final Double licenscedStaffingHours;
    private final Double totalNurseStaffingHours;

    public StateAverage(ResultSet resultSet) throws SQLException {
        this(State.valueOf(resultSet.getString(STATE_COLUMN)),
                Double.valueOf(resultSet.getString(CNA_STAFFING_HOURS_COLUMN)),
                Double.valueOf(resultSet.getString(LPN_STAFFING_HOURS_COLUMN)),
                Double.valueOf(resultSet.getString(RN_STAFFING_HOURS_COLUMN)),
                Double.valueOf(resultSet.getString(LICENCSED_STAFFING_HOURS_COLUMN)),
                Double.valueOf(resultSet.getString(TOTAL_NURSE_STAFFLING_HOURS_COLUMN)));
    }


    public StateAverage(State state, double cnaStaffingHours, double lpnStaffingHours, double rnStaffingHours, double
            licenscedStaffingHours, double totalNurseStaffingHours) {
        this.state = state;
        this.cnaStaffingHours = cnaStaffingHours;
        this.lpnStaffingHours = lpnStaffingHours;
        this.rnStaffingHours = rnStaffingHours;
        this.licenscedStaffingHours = licenscedStaffingHours;
        this.totalNurseStaffingHours = totalNurseStaffingHours;
    }

    public State getState() {
        return state;
    }

    public Double getCnaStaffingHours() {
        return cnaStaffingHours;
    }

    public Double getLpnStaffingHours() {
        return lpnStaffingHours;
    }

    public Double getRnStaffingHours() {
        return rnStaffingHours;
    }

    public Double getLicenscedStaffingHours() {
        return licenscedStaffingHours;
    }

    public Double getTotalNurseStaffingHours() {
        return totalNurseStaffingHours;
    }
}
