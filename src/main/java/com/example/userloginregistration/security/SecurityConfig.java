package com.example.userloginregistration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    //authentication
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails ADMIN= User.withUsername("Yegana").
                password(passwordEncoder.encode("yegana12")).roles("ADMIN").build();
        UserDetails USER=User.withUsername("John").password(passwordEncoder.encode("john1234")).roles("user").build();

        // will store these user details in memory
        return  new InMemoryUserDetailsManager(ADMIN,USER);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                authorize->authorize.requestMatchers("/users/welcome").permitAll()
                        .requestMatchers("/users/**").authenticated())
                .formLogin(login->login.loginPage("/users")).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
