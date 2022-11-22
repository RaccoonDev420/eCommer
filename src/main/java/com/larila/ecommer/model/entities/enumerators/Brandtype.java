package com.larila.ecommer.model.entities.enumerators;

public enum Brandtype {
    BICICLETAS, ACCESORIOS, PARTES, TODO;
    public static final String[] SIMPLE_OPERATION_SET = { "bicicletas", "accesorios", "partes", "todo" };
    public static Brandtype getBrandType(String operacion){
        switch (operacion){
            case "bicicletas":
                return Brandtype.BICICLETAS;
            case "accesorios":
                return Brandtype.ACCESORIOS;
            case "partes":
                return Brandtype.PARTES;
            case "todo":
                return Brandtype.TODO;
            default:
                return null;
        }
    }
}
