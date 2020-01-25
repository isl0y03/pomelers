package com.pomelers.domain.kbn;

import java.util.stream.Stream;

public class EnumFieldConvertor {

    // Prohibit instantiation
    private EnumFieldConvertor() {

    }

    /**
     * @param type
     * @param value
     * @return Enum field
     */
    public static <T extends Enum<T> & EnumField> T toEnum(final Class<T> type, final String value) {
        return Stream.of(type.getEnumConstants())
                .filter(it -> it.value().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Enum class " + type + " doesn't have field that matches " + value));
    }
}
