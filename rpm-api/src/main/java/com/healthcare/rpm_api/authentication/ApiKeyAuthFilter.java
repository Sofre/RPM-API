package com.healthcare.rpm_api.authentication;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.io.IOException;



public class ApiKeyAuthFilter extends AbstractAuthenticationProcessingFilter {

    private static final String API_KEY_HEADER = "API-Key";
    private static final String API_SECRET_HEADER = "API-Secret";

    // request on header
    public ApiKeyAuthFilter(RequestMatcher requiresAuth) {
        super(requiresAuth);
    }

    // Serverlet request key and returns response
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {
        String apiKey = request.getHeader(API_KEY_HEADER);
        String apiSecret = request.getHeader(API_SECRET_HEADER);

        if (apiKey == null || apiSecret == null) {
            throw new RuntimeException("Missing API Key or Secret");
        }

        Authentication auth = new ApiKeyAuthenticationToken(apiKey, apiSecret);
        return getAuthenticationManager().authenticate(auth);
    }
    // response successfull
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}