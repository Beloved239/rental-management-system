package com.tobi.rentalmanagementsystem.Util;

import java.util.Objects;

public class PropertyCode {
    private static int lastApartmentCode;
    private static int lastHouseCode;
    private static int lastCondoCode;

    public static String generatePropertyCode(String propertyType){
        String prefix = "";
        int lastCode = 0;

        if (Objects.equals(propertyType, "Apartment")){
            prefix = "APA";
            lastCode = lastApartmentCode;
        } else if (Objects.equals(propertyType, "House")) {
            prefix = "HOU";
            lastCode = lastHouseCode;

        } else if (Objects.equals(propertyType, "Condo")) {
            prefix = "CON";
            lastCode = lastCondoCode;
        }else throw new IllegalArgumentException("Invalid property type: " + propertyType);

        String suffix = String.format("%04d", lastCode +1);
        String propertyCode = prefix + suffix;

        switch (propertyType){
            case "Apartment" -> lastApartmentCode++;
            case "House" -> lastHouseCode++;
            case "Condo" -> lastCondoCode++;
        }

        return propertyCode;

    }
}
