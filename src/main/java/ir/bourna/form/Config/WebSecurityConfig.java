package ir.bourna.form.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().addFilterBefore(new SimpleCORSFilter(), ChannelProcessingFilter.class)
                .authorizeRequests().antMatchers(
//                "/v2/api-docs",
//                "/actuator/**",
//                "/configuration/ui",
//                "/swagger-resources/**",
//                "/configuration/security",
//                "/swagger-ui.html",
//                "/webjars/**",
//                "/api/v2/user",
//                "/api/v2/user/login",
//                "/api/v1/igap/callback",
//                "/swagger-ui.html", "/swagger-ui.html/**", "/webjars/springfox-swagger-ui/**",
//                "/authenticate/**", "/cafebazaar", "/cafebazaartest", "/api/v1/user/login",
//                "/api/v1/user/confirmotp/**", "/api/v1/user", "/api/v1/user/launcher-subs",
//                "/api/v1/payment/**", "/api/v1/shop", "/api/v1/launcher/**", "/images/**").permitAll()
                "/**").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/api/v1/challenges/**").hasAnyRole("ADMIN","IGAP")
//                .antMatchers("/user").hasAnyRole("ADMIN", "USER").
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.cors().configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.addAllowedOrigin("*");
            config.setAllowCredentials(true);
            return config;
        });

    }

}