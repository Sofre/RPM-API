package com.healthcare.rpm_api.authentication;




import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;



public class ApiKeyAuthenticationToken extends AbstractAuthenticationToken {

    private final String apiKey;
    private final String apiSecret;
    // creates key and secret
    public ApiKeyAuthenticationToken(String apiKey, String apiSecret) {
        super(null);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        setAuthenticated(false);
    }
    // creates authorites and assigned authenticaed meaning these roles will have authentication
    public ApiKeyAuthenticationToken(String apiKey, String apiSecret, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.apiSecret;
    }

    @Override
    public Object getPrincipal() {
        return this.apiKey;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}