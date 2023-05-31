package com.SplitEasier.spliteasier.splitwise;

import com.SplitEasier.spliteasier.splitwise.model.Group;
import com.SplitEasier.spliteasier.splitwise.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class SplitwiseAPI {
    private final Logger logger = LoggerFactory.getLogger(SplitwiseAPI.class);
    private final HttpHeaders httpHeaders;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public SplitwiseAPI(HttpHeaders httpHeaders, RestTemplate restTemplate, ObjectMapper objectMapper)  {
        this.httpHeaders = httpHeaders;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public User getCurrentUserDetails() throws JsonProcessingException, URISyntaxException {
        HttpEntity<String> httpEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(URL.GET_CURRENT_USER));
        objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL.GET_CURRENT_USER, HttpMethod.GET, httpEntity, String.class);
        logger.debug("Payload Received: {}", responseEntity.getBody());
        return objectMapper.readValue(responseEntity.getBody(), User.class);
    }
    public Group createGroup(String name, String groupType, boolean simplifyDebt, String firstName, String lastName, String email) throws JsonProcessingException, URISyntaxException {
        Group group = new Group(name, groupType, simplifyDebt, email, firstName, lastName);
        String body = new ObjectMapper().writeValueAsString(group);
        logger.debug("Sending payload: {}", body);
        objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> httpEntity = new RequestEntity<>(body, httpHeaders, HttpMethod.POST, new URI(URL.CREATE_GROUP_URL));
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL.CREATE_GROUP_URL,HttpMethod.POST, httpEntity, String.class);
        logger.debug("Create Group Response: {}", responseEntity.getBody());
        return objectMapper.readValue(responseEntity.getBody(), Group.class);
    }


}