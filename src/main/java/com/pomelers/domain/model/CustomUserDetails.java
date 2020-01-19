package com.pomelers.domain.model;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails extends UserDetails {

    AuthenticatedUser getAuthenticatedUser();
}
