package com.inn.cafe.JWT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	 
	
	private final JwtFilter jwtFilter;
	
	public SecurityConfig(JwtFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(cors -> cors. configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()))
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests ->
                authorizeRequests
                .requestMatchers("/user/login","/user/signup", "/user/forgotPassword").permitAll()
                
                .anyRequest().authenticated())
                .exceptionHandling()
                .and()
                .sessionManagement(sessionManagement ->
                	sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }

   @Bean
   public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    
   }
    @Bean
    public AuthenticationConfiguration authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return (AuthenticationConfiguration) authenticationConfiguration.getAuthenticationManager();
    }
}