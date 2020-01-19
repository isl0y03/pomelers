package com.pomelers.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticatedUser {
    @Getter
    private final Integer id;
    @Getter
    private final String username;
}
