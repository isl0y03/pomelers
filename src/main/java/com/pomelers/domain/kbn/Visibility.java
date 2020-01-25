package com.pomelers.domain.kbn;

public enum Visibility implements EnumField {
    PUBLIC("1"),
    PROJECT("2"),
    PRIVATE("3"),
    ;
    private String value;

    private Visibility(final String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return this.value;
    }

}
