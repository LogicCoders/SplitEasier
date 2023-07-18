package com.SplitEasier.spliteasier.splitwise.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AccountAD extends Account {

    public AccountAD(@Value("${splitwise.account.AD.APIKey}") String apikey, HttpHeaders httpHeaders) {
       super(apikey, httpHeaders);
    }

}
