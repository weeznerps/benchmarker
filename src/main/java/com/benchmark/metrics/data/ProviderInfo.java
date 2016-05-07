package com.benchmark.metrics.data;

/**
 * @author jsanderson 
 */
public class ProviderInfo {

    private final String providerNumber;
    private final String providerName;
    private final String address;
    private final String city;
    private final State state;
    private final int zipcode;
    private final String phoneNumber;
    private final OwnershipType ownershipType;
    private final ProviderType providerType;
    private final int numBeds;
    private final int occupiedBeds;
    private final Rating overallRating;
    private final Rating healthInspectionRating;
    private final Rating qualityRating;
    private final Rating staffingRating;


    public enum Rating {
        _1(1),_2(2),_3(3),_4(4),_5(5);

        private int value;
        Rating(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Rating getRating(int value) {
            for (Rating rating : Rating.values()) {
                if (value == rating.getValue()) {
                    return rating;
                }
            }
            return null;
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
        NJ,;
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


        public ProviderType getProviderType(String type) {
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


        public OwnershipType getOwnershipType(String type) {
            for (OwnershipType ownershipType : OwnershipType.values()) {
                if (type.equals(ownershipType.getType())) {
                    return ownershipType;
                }
            }
            return null;
        }
    }
}
