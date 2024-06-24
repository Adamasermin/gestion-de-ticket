package com.api.systeme_de_gestion_de_ticket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.api.systeme_de_gestion_de_ticket.service.CustomUserDetailService;

import lombok.AllArgsConstructor;

import static org.springframework.security.config.Customizer.withDefaults; // Importation statique pour withDefaults

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private CustomUserDetailService customUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Utilisation correcte de la désactivation de CSRF
            .authorizeHttpRequests(authorizeRequests -> {
                authorizeRequests.requestMatchers("/admin/**", "/formateur/**").permitAll();
                authorizeRequests.requestMatchers("/apprenants/creer").hasRole("ADMIN");
                authorizeRequests.requestMatchers("/apprenants/**").permitAll();
                authorizeRequests.requestMatchers("/faq/afficher").hasRole("APPRENANT");
                authorizeRequests.requestMatchers("/faq/**").hasRole("FORMATEUR");
                authorizeRequests.requestMatchers("/ticket/repondre").hasRole("FORMATEUR");
                authorizeRequests.requestMatchers("/ticket/**").hasRole("APPRENANT");
                authorizeRequests.anyRequest().authenticated();
            })
            .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
            .httpBasic(withDefaults()); // Utilisation correcte de withDefaults
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailService;
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails admin = User.builder()
    //         .username("admin")
    //         .password("$2y$10$JTvTdoZaO6vQMhD6lrA5Gu6c9VQo5JWb1Ve2ZLijSfjmXS5PPeyUK") 
    //         .roles("ADMIN")
    //         .build();

    //     UserDetails formateur = User.builder()
    //         .username("formateur")
    //         .password("$2y$10$F7tJl6lWlKRThSU29.24LuYDNMw7cZZE9igcbpHG0cytgAcaj6WUC") 
    //         .roles("FORMATEUR")
    //         .build();

    //     UserDetails apprenant = User.builder()
    //         .username("apprenant")
    //         .password("$2y$10$MKNyvtxtVvj/s4rQidDqL.Yr8RdHkzZTmGKPel6BFgNCXHYjgra9C") 
    //         .roles("APPRENANT")
    //         .build();

    //     return new InMemoryUserDetailsManager(admin, formateur, apprenant);
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
