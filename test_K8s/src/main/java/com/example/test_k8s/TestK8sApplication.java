package com.example.test_k8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestK8sApplication.class, args);
        System.out.println("test app");
    }

}
