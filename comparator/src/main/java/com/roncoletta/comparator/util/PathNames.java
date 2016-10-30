package com.roncoletta.comparator.util;

/**
 * Created by roncoletta on 29/10/16.
 */
public enum PathNames {

    USER_LOCAL_KEY_VARIABLE("java.io.tmpdir"),
    APP_DIR("package-comparator");

    private final String value;

    PathNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
