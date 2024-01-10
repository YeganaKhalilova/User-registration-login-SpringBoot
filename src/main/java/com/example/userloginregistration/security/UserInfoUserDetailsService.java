package com.example.userloginregistration.security;

import com.example.userloginregistration.user.User;
import com.example.userloginregistration.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;



public class UserInfoUserDetailsService implements UserDetailsService {

    public UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userInfo = Optional.ofNullable(repository.findByEmail(email));
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));

    }

}
