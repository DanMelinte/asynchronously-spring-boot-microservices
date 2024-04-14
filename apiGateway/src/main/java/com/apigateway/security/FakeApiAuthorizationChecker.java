package com.apigateway.security;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("fakeCheker")
public class FakeApiAuthorizationChecker implements ApiKeyAuthorizationChecker {

    private final static Map<String, List<String>> keys = Map.of(
            "somekey", List.of("customer")
    );


    @Override
    public boolean isAuthorized(String key, String application) {

        return keys.getOrDefault(key, List.of())
                .stream()
                .anyMatch(k -> k.contains(application));
    }
}
