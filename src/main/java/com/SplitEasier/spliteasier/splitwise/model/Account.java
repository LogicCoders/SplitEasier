package com.SplitEasier.spliteasier.splitwise.model;
import com.SplitEasier.spliteasier.splitwise.util.APIKey;
import org.springframework.stereotype.Component;

@Component
public class Account {
    private APIKey apiKey;
    public Account( APIKey apiKey){
        this.apiKey = apiKey;
    }
    public APIKey getApiKey() {
        return apiKey;
    }
    public void setApiKey(APIKey apiKey) {
        this.apiKey = apiKey;
    }
}
