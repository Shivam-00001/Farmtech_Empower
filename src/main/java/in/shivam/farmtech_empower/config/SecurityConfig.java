package in.shivam.farmtech_empower.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(); 
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests(authorizeRequests -> authorizeRequests
                // Allow access to static resources and public pages
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/", "/index", "/about", "/contact", "/signin", "/signup", "/saveUser",
                        "/PrivacyPolicy", "/Terms_of_Service", "/ourproducts", "/calculator", "/OrderNow")
                .permitAll()
                // Restrict access to authenticated users only
                .requestMatchers("/user/**", "/product-details", "/submitOrder", "/calculate").authenticated())
                .formLogin(formLogin -> formLogin.loginPage("/signin").loginProcessingUrl("/login")
                        .defaultSuccessUrl("/user/profile", true) // Default user profile page
                        .permitAll())
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/signin")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll());
        return http.build();
    }

}
