package com.benchmark.metrics.data;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jsanderson
 */
public class ProviderInfo {

    public static final int PROVIDER_NUMBER_COLUMN = 1;
    public static final int PROVIDER_NAME_COLUMN = 2;
    public static final int ADDRESS_COLUMN = 3;
    public static final int CITY_COLUMN = 4;
    public static final int STATE_COLUMN = 5;
    public static final int ZIP_COLUMN = 6;
    public static final int PHONE_COLUMN = 7;
    public static final int OWNERSHIP_COLUMN = 10;
    public static final int NUM_BEDS_COLUMN = 11;
    public static final int OCCUPIED_BEDS_COLUMN = 12;
    public static final int PROVIDER_TYPE_COLUMN = 13;
    public static final int OVERALL_RATING_COLUMN = 23;
    public static final int HEALTH_INSPECTION_RATING_COLUMN = 25;
    public static final int QUALITY_RATING_COLUMN = 27;
    public static final int STAFFING_RATING_COLUMN = 29;
    public static final int RN_STAFFING_RATING_COLUMN = 31;
    public static final int CNA_STAFFING_HOURS_COLUMN = 35;
    public static final int LPN_STAFFING_HOURS_COLUMN = 36;
    public static final int RN_STAFFING_HOURS_COLUMN = 37;
    public static final int LICENCSED_STAFFING_HOURS_COLUMN = 38;
    public static final int TOTAL_NURSE_STAFFLING_HOURS_COLUMN = 39;

    private final String providerNumber;
    private final String providerName;
    private final String address;
    private final String city;
    private final State state;
    private final Integer zipcode;
    private final String phoneNumber;
    private final OwnershipType ownershipType;
    private final Integer numBeds;
    private final Integer occupiedBeds;
    private final ProviderType providerType;
    private final Rating overallRating;
    private final Rating healthInspectionRating;
    private final Rating qualityRating;
    private final Rating staffingRating;
    private final Rating rnStaffingRating;
    private final Double cnaStaffingHours;
    private final Double lpnStaffingHours;
    private final Double rnStaffingHours;
    private final Double licenscedStaffingHours;
    private final Double totalNurseStaffingHours;

    public ProviderInfo(ResultSet resultSet) throws SQLException {
        this(resultSet.getString(PROVIDER_NUMBER_COLUMN), resultSet.getString(PROVIDER_NAME_COLUMN), resultSet
                        .getString(ADDRESS_COLUMN), resultSet.getString(CITY_COLUMN), State.valueOf(resultSet.getString
                        (STATE_COLUMN)), Integer.valueOf(resultSet.getInt(ZIP_COLUMN)), resultSet.getString
                        (PHONE_COLUMN), OwnershipType.getOwnershipType(resultSet.getString(OWNERSHIP_COLUMN)), Integer.valueOf
                (resultSet.getString(NUM_BEDS_COLUMN)), Integer.valueOf
                        (resultSet.getString(OCCUPIED_BEDS_COLUMN)), ProviderType.getProviderType(resultSet.getString
                (PROVIDER_TYPE_COLUMN)),
                Rating.getRating(resultSet.getString(OVERALL_RATING_COLUMN)),
                Rating.getRating(resultSet.getString(HEALTH_INSPECTION_RATING_COLUMN)),
                Rating.getRating(resultSet.getString(QUALITY_RATING_COLUMN)),
                Rating.getRating(resultSet.getString(STAFFING_RATING_COLUMN)),
                Rating.getRating(resultSet.getString(RN_STAFFING_RATING_COLUMN)),
                Double.valueOf(resultSet.getString(CNA_STAFFING_HOURS_COLUMN)),
                Double.valueOf(resultSet.getString(LPN_STAFFING_HOURS_COLUMN)),
                Double.valueOf(resultSet.getString(RN_STAFFING_HOURS_COLUMN)),
                Double.valueOf(resultSet.getString(LICENCSED_STAFFING_HOURS_COLUMN)),
                Double.valueOf(resultSet.getString(TOTAL_NURSE_STAFFLING_HOURS_COLUMN)));
    }

    public ProviderInfo(String providerNumber, String providerName, String address, String city, State state, int
            zipcode, String phoneNumber, OwnershipType ownershipType, int numBeds, int
                                occupiedBeds, ProviderType providerType, Rating overallRating, Rating
                                healthInspectionRating, Rating
                                qualityRating, Rating
                                staffingRating, Rating rnStaffingRating, double cnaStaffingHours, double
                                lpnStaffingHours, double
                                rnStaffingHours, double licenscedStaffingHours, double totalNurseStaffingHours) {
        this.providerNumber = providerNumber;
        this.providerName = providerName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.ownershipType = ownershipType;
        this.providerType = providerType;
        this.numBeds = numBeds;
        this.occupiedBeds = occupiedBeds;
        this.overallRating = overallRating;
        this.healthInspectionRating = healthInspectionRating;
        this.qualityRating = qualityRating;
        this.staffingRating = staffingRating;
        this.rnStaffingRating = rnStaffingRating;
        this.cnaStaffingHours = cnaStaffingHours;
        this.lpnStaffingHours = lpnStaffingHours;
        this.rnStaffingHours = rnStaffingHours;
        this.licenscedStaffingHours = licenscedStaffingHours;
        this.totalNurseStaffingHours = totalNurseStaffingHours;
    }

    public String getProviderNumber() {
        return providerNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public State getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OwnershipType getOwnershipType() {
        return ownershipType;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public Integer getNumBeds() {
        return numBeds;
    }

    public Integer getOccupiedBeds() {
        return occupiedBeds;
    }

    public Rating getOverallRating() {
        return overallRating;
    }

    public Rating getHealthInspectionRating() {
        return healthInspectionRating;
    }

    public Rating getQualityRating() {
        return qualityRating;
    }

    public Rating getStaffingRating() {
        return staffingRating;
    }

    public Rating getRnStaffingRating() {
        return rnStaffingRating;
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

    public enum Rating {
        _1(1), _2(2), _3(3), _4(4), _5(5);

        private int value;

        Rating(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Rating getRating(int value) {
            for (Rating rating : Rating.values()) {
                if (value == rating.getValue()) {
                    return rating;
                }
            }
            return null;
        }

        public static Rating getRating(String value) {
            return getRating(Integer.valueOf(value));
        }
    }


    public enum State {
        PA,
        AZ,
        FL,
        MT,
        LA,
        GU,
        NM,
        AK,
        NC,
        OR,
        VT,
        MS,
        AR,
        IL,
        MO,
        HI,
        IN,
        WY,
        UT,
        MI,
        KS,
        MD,
        VI,
        GA,
        DC,
        WI,
        MN,
        OH,
        NE,
        CT,
        NV,
        PR,
        OK,
        AL,
        CA,
        CO,
        DE,
        ND,
        WV,
        KY,
        WA,
        ME,
        RI,
        SD,
        TN,
        VA,
        NH,
        IA,
        SC,
        NY,
        MA,
        ID,
        TX,
        NJ,
        NATION;
    }


    public enum ProviderType {
        MEDICARE("Medicare"),
        MEDICAID("Medicaid"),
        MEDICARE_AND_MEDICAID("Medicare and Medicaid"),;

        String type;

        ProviderType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }


        public static ProviderType getProviderType(String type) {
            for (ProviderType providerType : ProviderType.values()) {
                if (type.equals(providerType.getType())) {
                    return providerType;
                }
            }
            return null;
        }
    }

    public enum OwnershipType {
        NON_PROFIT_OTHER("Non profit - Other"),
        NON_PROFIT_CHURCH_RELATED("Non profit - Church related"),
        GOVERNMENT_CITY("Government - City"),
        FOR_PROFIT_CORPORATION("For profit - Corporation"),
        FOR_PROFIT_LIMITED_LIABILITY_COMPANY("For profit - Limited Liability company"),
        GOVERNMENT_CITY_COUNTY("Government - City/county"),
        FOR_PROFIT_INDIVIDUAL("For profit - Individual"),
        GOVERNMENT_HOSPITAL_DISTRICT("Government - Hospital district"),
        GOVERNMENT_COUNTY("overnment - County"),
        FOR_PROFIT_PARTNERSHIP("For profit - Partnership"),
        NON_PROFIT_CORPORATION("Non profit - Corporation"),
        GOVERNMENT_FEDERAL("Government - Federal"),
        GOVERNMENT_STATE("Government - State"),;

        String type;

        OwnershipType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }


        public static OwnershipType getOwnershipType(String type) {
            for (OwnershipType ownershipType : OwnershipType.values()) {
                if (type.equals(ownershipType.getType())) {
                    return ownershipType;
                }
            }
            return null;
        }
    }
}
