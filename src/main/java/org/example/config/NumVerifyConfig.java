package org.example.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@PropertySource("classpath:.env")
public class NumVerifyConfig {

    @Value("${API_ACCESS_KEY}")
    private String apiKey;
}
