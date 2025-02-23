package com.learning.SocialLoginOAuth2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(req->req.requestMatchers("/secure").authenticated().anyRequest().permitAll())
        .formLogin(Customizer.withDefaults())
        .oauth2Login(Customizer.withDefaults())
        .build();
  }

  @Bean
  ClientRegistrationRepository clientRegistrationRepository() {
    ClientRegistration github = githubClientRegistration();
    return new InMemoryClientRegistrationRepository(github);
  }

  private ClientRegistration githubClientRegistration() {
    return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("")
        .clientSecret("").build();
  }
}
