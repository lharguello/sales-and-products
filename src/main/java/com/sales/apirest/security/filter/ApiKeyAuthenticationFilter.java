package com.sales.apirest.security.filter;

import com.sales.apirest.security.ApiKeyValidator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Component
public class ApiKeyAuthenticationFilter extends GenericFilterBean {

    private static final String API_KEY_HEADER = "x-api-key";

    private final ApiKeyValidator apiKeyValidator;

    // list to exclude
    private final List<String> publicEndpoints = List.of("/api/public", "/swagger-ui/**", "/v3/api-docs/**" );

    @Autowired
    public ApiKeyAuthenticationFilter(ApiKeyValidator apiKeyValidator) {
        this.apiKeyValidator = apiKeyValidator;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getServletPath();

        if (path.startsWith("/v3/api-docs") || path.startsWith("/swagger-ui") || path.startsWith("swagger-config") || path.startsWith("/h2-ui")) {
            filterChain.doFilter(request, response);
            return;
        }

        String apiKey = httpRequest.getHeader(API_KEY_HEADER);

        if (apiKey == null || apiKey.isEmpty() || !apiKeyValidator.isValidApiKey(apiKey)) {
            httpResponse.setContentType("application/json");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("{\"status\":401, \"error\":\"Unauthorized\", \"message\":\"Access denied\", \"timestamp\": \""+  LocalDateTime.now()+"\"}");
            return;
        }

        AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                apiKey,
                null,
                Collections.<GrantedAuthority>emptyList()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
