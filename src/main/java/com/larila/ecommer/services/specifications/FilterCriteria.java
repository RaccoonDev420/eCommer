package com.larila.ecommer.services.specifications;

public class FilterCriteria {
    private String field;
    private String splitter;
    private Object value;

    public FilterCriteria() {
    }

    public FilterCriteria(String field, String splitter, Object value) {
        this.field = field;
        this.splitter = splitter;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSplitter() {
        return splitter;
    }

    public void setSplitter(String splitter) {
        this.splitter = splitter;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
