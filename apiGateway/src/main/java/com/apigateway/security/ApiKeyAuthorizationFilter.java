package com.apigateway.security;


import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class ApiKeyAuthorizationFilter implements GlobalFilter, Ordered {

    private final FakeApiAuthorizationChecker fakeApiAuthorizationChecker;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Authorization Filer checking the key ...");

        // obtain id, uri, order, predicate, gwFilters, metadata
        Route attribute = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        List<String> apiKey = exchange.getRequest().getHeaders().keySet().stream().filter(a -> a.equals("somekey")).collect(Collectors.toList());
        String application = attribute.getId();

        if (application == null ||
                (apiKey == null || apiKey.isEmpty()) ||
                !fakeApiAuthorizationChecker.isAuthorized(apiKey.get(0), application)) {
            System.out.println("unauthorized client");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "unauthorized client");
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }


}
