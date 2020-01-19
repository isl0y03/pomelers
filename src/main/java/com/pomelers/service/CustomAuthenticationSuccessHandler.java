package com.pomelers.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import com.pomelers.domain.model.CustomUserDetails;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
            final HttpServletResponse response, final Authentication authentication)
            throws IOException, ServletException {

        final CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        setDefaultTargetUrl("/" + userDetails.getAuthenticatedUser().getId());
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
