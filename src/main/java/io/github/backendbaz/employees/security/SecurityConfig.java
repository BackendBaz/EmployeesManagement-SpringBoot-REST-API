package io.github.backendbaz.employees.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        var amir = User.builder()
                .username("amir")
                .password("{noop}amir12")
                .roles("EMPLOYEE")
                .build();
        var zahra = User.builder()
                .username("zahra")
                .password("{noop}zhra45")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        var bagher = User.builder()
                .username("bagher")
                .password("{noop}bgr66")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(amir, zahra, bagher);
    }

}
