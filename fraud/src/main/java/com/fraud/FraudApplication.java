package com.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.clients.openFeign"
)
@PropertySources({
        @PropertySource("classpath:clients-openFeign-${spring.profiles.active}.properties")
})
public class FraudApplication
{
    public static void main( String[] args)
    {
        SpringApplication.run(FraudApplication.class,args);
    }
}
