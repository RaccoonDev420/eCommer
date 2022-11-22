package com.larila.ecommer.model.entities.enumerators;

public enum Frame {
    RIGIDO, SUSPENCION;

    public static final String[] SIMPLE_OPERATION_SET = { "rigido", "suspencion" };

    public static Frame getFrame(String operacion){
        switch (operacion){
            case "rigido":
                return Frame.RIGIDO;
            case "suspencion":
                return Frame.SUSPENCION;
            default:
                return null;
        }
    }
}
