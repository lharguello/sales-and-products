package com.sales.apirest.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyValidator {
    @Value("${x-api-key-secret}")
    private String apiKey;

    public boolean isValidApiKey(String providedApiKey) {
        return apiKey != null && apiKey.equals(providedApiKey);
    }
}
