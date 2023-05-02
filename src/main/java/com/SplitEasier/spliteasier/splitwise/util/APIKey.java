package com.SplitEasier.spliteasier.splitwise.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class APIKey {

    private final String KEY;

    public APIKey(@Value("${splitwise.account.APIKey}") String KEY) {
        this.KEY = KEY;
    }

    public String getKEY() {
        return KEY;
    }
}
