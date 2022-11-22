package com.larila.ecommer.model.entities.enumerators;

public enum BrakeType {
    DISCO, HIDRAULICO;
    public static final String[] SIMPLE_OPERATION_SET = { "disco", "hidraulico" };
    public static BrakeType getBrakeType(String operacion){
        switch (operacion){
            case "disco":
                return BrakeType.DISCO;
            case "hidraulico":
                return BrakeType.HIDRAULICO;
            default:
                return null;
        }
    }
}
