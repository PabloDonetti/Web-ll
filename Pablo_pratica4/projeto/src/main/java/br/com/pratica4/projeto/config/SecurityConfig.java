package br.com.pratica4.projeto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import br.com.pratica4.projeto.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                // Permite acesso público a essas URLs
                .requestMatchers("/", "/login", "/register", "/css/**", "/js/**").permitAll()
                // Exige autenticação para qualquer outra URL
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login") // Página de login customizada
                .loginProcessingUrl("/login") // URL que o Spring Security processa o login
                .defaultSuccessUrl("/lista", true) // Redireciona para /lista após sucesso
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // URL para fazer logout
                .logoutSuccessUrl("/login?logout") // Redireciona para a pág de login com msg
                .permitAll()
            );
        return http.build();
    }
}