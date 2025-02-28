package com.JWTApplication.security.service;

import com.JWTApplication.repository.UserRepository;
import com.JWTApplication.security.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails result = null;
        Set<GrantedAuthority> authorities3 = new HashSet<GrantedAuthority>();
        Map<String, Object> userDetails = userRepository.findByEmail(username);

        if (!userDetails.isEmpty()) {
            if (!userDetails.get("is_deleted").equals(true)) {
                GrantedAuthority authorityGuest = new SimpleGrantedAuthority((String) userDetails.get("role_code"));
                authorities3.add(authorityGuest);
                return new UserDetailsImpl(
                        (Integer) userDetails.get("user_id"),
                        (String) userDetails.get("first_name"),
                        (String) userDetails.get("middle_name"),
                        (String) userDetails.get("last_name"),
                        (String) userDetails.get("username"),
                        (String) userDetails.get("password"),
                        (Long) userDetails.get("contact_number"),
                        (Integer) userDetails.get("manager_id"),
                        (Integer) userDetails.get("department_id"),
                        (Integer) userDetails.get("role_id"),
                        (Boolean) userDetails.get("is_deleted"),
                        authorities3
                );
            } else {
                System.err.println("Account Locked due to Account deleted");

                throw new LockedException("Account Locked due to Account deleted");
            }
        } else {
            System.err.println("Wrong username or password");

            throw new BadCredentialsException("Wrong username or password");
        }

    }
}
