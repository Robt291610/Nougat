package com.nougat.authentication.config;

import com.nougat.authentication.component.JwtAuthenticationFilter;
import com.nougat.authentication.mapper.UserMapper;
import com.nougat.authentication.services.CustomUserDetailsService;
import com.nougat.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //private final CustomUserDetailsService userService;
    //private final JwtAuthenticationFilter jwtAuthFilter;
    //private final UserDetailsService userDetailsService;
//    private final UserRepository userRepository;
    //private final UserMapper userMapper;

//    public SecurityConfig(
////                          UserRepository userRepository,
//                          ) {
//        //this.jwtAuthFilter = jwtAuthFilter;
//        //this.userDetailsService = userDetailsService;
//        //this.userService = userService;
////        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
//                .authenticationProvider(authenticationProvider())
//                .csrf(csrf -> csrf.disable())
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))


                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**"
                        ).permitAll()
                        //.anyRequest().authenticated()
                )
               // .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

//        @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        var user = User.builder()
//                .username("admin")
//                .password(encoder.encode("password"))
//                .roles("ADMIN")
//                .build();
//        return userDetailsService;
//    }

    //need to be implemented
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

//    @Bean
//    public UserRepository userRepository() {
//        return userRepository;
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        return new DaoAuthenticationProvider(userService); //passwordEncoder
//    }

//    @Bean
//    public UserRepository userRepository() {
//        return userRepository;
//    }

//    @Bean
//    public UserMapper userMapper() {
//        return  userMapper;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
