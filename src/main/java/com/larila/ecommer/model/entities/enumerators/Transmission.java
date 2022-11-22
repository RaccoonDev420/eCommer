package com.larila.ecommer.model.entities.enumerators;

public enum Transmission {
    MECANICA, HIDRAULICA;

    public static final String[] SIMPLE_OPERATION_SET = { "mecanica", "hidraulica" };

    public static Transmission getTransmision(String operation){
        switch (operation){
            case "mecanica":
                return Transmission.MECANICA;
            case "hidraulica":
                return Transmission.HIDRAULICA;
            default:
                return null;
        }
    }
}
