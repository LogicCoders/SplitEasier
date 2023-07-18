package com.SplitEasier.spliteasier.splitwise.model;

import com.SplitEasier.spliteasier.splitwise.util.Constants;
import org.springframework.http.HttpHeaders;

public abstract class Account {
    public String APIKey;
    public HttpHeaders httpHeaders;

    public Account(String APIKey, HttpHeaders httpHeaders) {
        this.APIKey = APIKey;
        this.httpHeaders = httpHeaders;
        setHttpHeaders(httpHeaders);
    }

    public String getAPIKey() {
        return APIKey;
    }
    public void setAPIKey(String APIKey) {
        this.APIKey = APIKey;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        httpHeaders.add(HttpHeaders.AUTHORIZATION, String.format("%s%c%s", Constants.BEARER,'\u0020' , APIKey));
    }

}
