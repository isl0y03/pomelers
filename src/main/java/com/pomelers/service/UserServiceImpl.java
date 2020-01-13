package com.pomelers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pomelers.domain.entity.LoginUser;
import com.pomelers.domain.model.UserDetailsImpl;
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
        // TODO Password stored in database is non encrypted.
        final String encoded = this.passwordEncoder.encode(user.getPassword());
        return new UserDetailsImpl(user.getEmail(), encoded);
    }

}
