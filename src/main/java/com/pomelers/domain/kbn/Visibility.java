package com.pomelers.domain.kbn;

import java.util.stream.Stream;
import lombok.NonNull;

public enum Visibility {
    PUBLIC("1"),
    PROJECT("2"),
    PRIVATE("3"),
    ;
    private String value;

    private Visibility(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static Visibility toEnum(@NonNull final String value) {
        return Stream.of(Visibility.values())
                .filter(it -> value.equals(it.toString()))
                .findFirst().orElse(PUBLIC);
    }
}
