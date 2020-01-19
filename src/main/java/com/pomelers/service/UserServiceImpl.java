package com.pomelers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pomelers.domain.entity.LoginUser;
import com.pomelers.domain.model.AuthenticatedUser;
import com.pomelers.domain.model.CustomUserDetailsImpl;
import com.pomelers.domain.model.SignUpForm;
import com.pomelers.domain.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final LoginUser user = this.repository.select(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }
        final AuthenticatedUser authenticated = new AuthenticatedUser(user.getId(), user.getUsername());
        return new CustomUserDetailsImpl(user.getEmail(), user.getPassword(), authenticated);
    }

    @Override
    public void register(final SignUpForm form) {
        final LoginUser user = new LoginUser();
        user.setEmail(form.getEmail());
        user.setUsername(form.getUsername());
        user.setPassword(this.passwordEncoder.encode(form.getPassword()));
        this.repository.register(user);
    }

}
