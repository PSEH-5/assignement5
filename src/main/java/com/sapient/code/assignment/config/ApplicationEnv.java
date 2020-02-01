package com.sapient.code.assignment.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationEnv {
    @Value("${api.name}")
    private String apiEndPoint;

    @Value("${api.key}")
    private String apiKey;

}
