package org.yarik.testTask.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.yarik.testTask.jwt.JwtConfigurer;
import org.yarik.testTask.jwt.JwtTokenProvider;
import org.yarik.testTask.service.UserService;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                .authorizeRequests()
//                    .antMatchers("**/car/add", "**/car/delete/").hasAnyRole("USER", "ADMIN")
//                    .antMatchers("**/delete/", "**/add/", "/api/car/getAll").hasRole("ADMIN")
//                    .antMatchers("/login", "/registration").permitAll()
//                    .antMatchers("/api/car/", "api/carBrand/", "api/carModel/", "api/typeAuto/").permitAll()
//                    .antMatchers("/api/user/").hasRole("ADMIN")
//                .and()
                    .apply(new JwtConfigurer(jwtTokenProvider));
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui/**", "/v3/api-docs/**");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).
                passwordEncoder(bCryptPasswordEncoder());
    }

}
