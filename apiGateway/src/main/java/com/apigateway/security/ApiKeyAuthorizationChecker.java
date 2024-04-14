package com.apigateway.security;

public interface ApiKeyAuthorizationChecker {

    boolean isAuthorized(String key, String application);



}
