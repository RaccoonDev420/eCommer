package com.larila.ecommer.model.entities.enumerators;

public enum Material {
    FIBRADECARBONO, ALUMINIO, TITANIO;
    public static final String[] SIMPLE_OPERATION_SET = { "fibraDeCarbono", "aluminio", "titanio" };

    public static Material getMaterial(String operacion){
        switch (operacion){
            case "fibraDeCarbono":
                return Material.FIBRADECARBONO;
            case "aluminio":
                return Material.ALUMINIO;
            case "titanio":
                return Material.TITANIO;
            default:
                return null;
        }
    }

}
