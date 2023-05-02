package com.SplitEasier.spliteasier.splitwise;
import com.SplitEasier.spliteasier.splitwise.model.Account;
import com.SplitEasier.spliteasier.splitwise.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.URL;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class SplitwiseAPI {

    private final HttpHeaders httpHeaders;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    public SplitwiseAPI(HttpHeaders httpHeaders, RestTemplate restTemplate, ObjectMapper objectMapper)  {
        this.httpHeaders = httpHeaders;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public User getCurrentUserDetails(Account account) throws JsonProcessingException, URISyntaxException {
        httpHeaders.add("Authorization", "Bearer"+" "+account.getApiKey().getKEY());
        HttpEntity<String> httpEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(URL.GET_CURRENT_USER));
        objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL.GET_CURRENT_USER, HttpMethod.GET, httpEntity, String.class);
        User user = objectMapper.readValue(responseEntity.getBody(), User.class);
        return objectMapper.readValue(responseEntity.getBody(), User.class);
    }


}