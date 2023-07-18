package com.SplitEasier.spliteasier.splitwise.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AccountDB extends Account {

    public AccountDB(@Value("${splitwise.account.DB.APIKey}") String apikey, HttpHeaders httpHeaders) {
        super(apikey, httpHeaders);
    }

}
