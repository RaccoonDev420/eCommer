package com.larila.ecommer.services.specifications;

public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    private String andOr;

    public SearchCriteria() {
    }

    public SearchCriteria(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public SearchCriteria(String key, String operation, Object value, String andOr) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.andOr = andOr;
    }

    public String getAndOr() {
        return andOr;
    }

    public void setAndOr(String andOr) {
        this.andOr = andOr;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isOrPredicate(){
        if(this.andOr == "%"){
            return true;
        }
        return false;

    }


}
