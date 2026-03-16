package com.uidai.aadhar.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@EnableMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http
        .csrf().disable()
        .authorizeRequests()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/attendance/punch", "/attendance/**", "/attendance/view/**").permitAll()
            .antMatchers("/file-upload/EOD").permitAll()
            .antMatchers("/operator/**", "/operator/new", "/operator/update").permitAll()
            .antMatchers("/operator/specific-info").permitAll()
            .antMatchers("/dashboard/**", "/dashboard/login-info/**").permitAll()
            .antMatchers("/device/**", "/center/**", "/api/enrolment/**", "/attendance/**", "/device/view/**").permitAll()
            .antMatchers("/alert/**").permitAll()
            .antMatchers("/center/**", "/center/view/**", "/center/view").permitAll()
            .antMatchers("/pay/**").permitAll()
            .anyRequest().authenticated()
        .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
