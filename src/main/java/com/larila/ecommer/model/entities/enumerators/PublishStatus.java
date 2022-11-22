package com.larila.ecommer.model.entities.enumerators;

import java.math.BigDecimal;

public enum PublishStatus {
    INACTIVE, PENDINGTOREVIEW, PUBLISHED;
    public static final String[] SIMPLE_OPERATION_SET = { "inactive", "pendingToReview", "published" };

    public static PublishStatus getPublishStatus(String operation){
        switch (operation){
            case "inactive":
                return PublishStatus.INACTIVE;
            case "pendingToReview":
                return PublishStatus.PENDINGTOREVIEW;
            case "publiched":
                return PublishStatus.PUBLISHED;
            default:
                return null;
        }
    }
}
