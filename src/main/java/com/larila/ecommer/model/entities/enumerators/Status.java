package com.larila.ecommer.model.entities.enumerators;

public enum Status {
    NUEVO, USADO, ACEPTABLE;

    public static final String[] SIMPLE_OPERATION_SET = { "nuevo", "usado", "aceptable" };

    public static Status getSimpleOperation(String input) {
        switch (input) {
            case "nuevo":
                return NUEVO;
            case "usado":
                return USADO;
            case "aceptable":
                return ACEPTABLE;
            default:
                return null;
        }
    }
}
