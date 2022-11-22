package com.larila.ecommer.model.entities.enumerators;

public enum AdminType {
    SUPERADMIN, CONTENTADMIN, DEVELOPER, USERADMIN;
    public static final String[] SIMPLE_OPERATION_SET = { "superAdmin", "contentAdmin", "developer", "userAdmin" };
    public static AdminType getAdmonType(String operacion){
        switch (operacion){
            case "superAdmin":
                return AdminType.SUPERADMIN;
            case "contentAdmin":
                return AdminType.CONTENTADMIN;
            case "developer":
                return AdminType.DEVELOPER;
            case "userAdmin":
                return AdminType.USERADMIN;
            default:
                return null;
        }
    }
}

