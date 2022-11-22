package com.larila.ecommer.model.entities.enumerators;

public enum Currency {
    MX, USD;
    public static final String[] SIMPLE_OPERATION_SET = { "mx", "usd" };

    public static Currency getCurrency(String operacion){
        switch (operacion){
            case "mx":
                return Currency.MX;
            case "usd":
                return Currency.USD;
            default:
                return null;
        }
    }
}
