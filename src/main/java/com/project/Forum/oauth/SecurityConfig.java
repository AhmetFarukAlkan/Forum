package com.project.Forum.oauth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.io.IOException;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@RequiredArgsConstructor
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
                http
//                .antMatcher("/login/**")
//                .authorizeRequests()
//                .antMatchers("/")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2Login();

//                .authorizeRequests()
//                .antMatchers(
//                        "/",
//                        "/login",
//                        "/oauth/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .oauth2Login()
//                .loginPage("/login");

//        -------------------------------------------------------------------

//                        .authorizeRequests()
//                        .antMatchers("/anonymous*")
//                        .anonymous()
//                        .antMatchers("/login*")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated()
//                        .and()
//                        .formLogin()
//                        .loginPage("/login.html")
//                        .loginProcessingUrl("/login")
//                        .failureUrl("/login.html?error=true")
//                        .and()
//                        .logout()
//                        .deleteCookies("JSESSIONID")
//                        .and()
//                        .rememberMe()
//                        .key("uniqueAndSecret");

//*********************************************************

                .csrf().disable()

//                .requestMatchers()
//                .antMatchers(
//                        "/users/**",
////                        "/**",
////                        "/",
//                        "/oauth2/authorization/google**",
//                        "/login/oauth2/code/google**"
////                        "/oauth2/authorization/google"
//                )
//                .and()

//

                .authorizeRequests()
                        .antMatchers(
//                                "/",
                                "/login/oauth2/code/google",
                                "/oauth2/authorization/google"
                        )
//                        .permitAll()
//                .anyRequest()
                .fullyAuthenticated()
//
                .and()
                .oauth2Login()
                        .loginPage("/oauth2/authorization/google")
//                        .loginProcessingUrl("/oauth2/authorization/google")

                //

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
//
                ;

                return http.build();
    }

//
//    @Bean
//    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests(
////                        (authorizeRequests) -> authorizeRequests.anyRequest().authenticated()
////                ).oauth2Login(oauth2Customize -> oauth2Customize
////                .loginProcessingUrl("/login")
////                .loginPage("/oauth2/authorization/google")
//////                .loginPage("/")
////
////                        .successHandler(new AuthenticationSuccessHandler() {
//////                            @Override
//////                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//////                                request.authenticate(response);
//////                            }
////                            @Override
////                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//////                                request.authenticate(response);
//////                                return "index";
////                            }
//////                            public String main(){
//////                                return "index";
//////                            }
////                        })
////                );
//
////        http
////                .csrf()
////                .disable()
////                .antMatcher("/**")
////                .authorizeRequests()
////                .antMatchers("/", "/index.html")
////                .permitAll()
////                .anyRequest()
////                .authenticated();
//
//
//
//
////        http
////                .csrf().disable()
//////                    "/home**/**"
////                .requestMatchers()
////                .antMatchers("/home**/**","/oauth2/authorization/google/login**","/oauth2/authorization/google**","/login/oauth2/code/google**")
////                .and()
////                .authorizeRequests().antMatchers("/").permitAll()
////                .anyRequest().fullyAuthenticated()
////                .and()
////                .oauth2Login()
////                //
////
////                //
////                .and()
////                .logout()
////                .logoutUrl("/home/logout")
////                .logoutSuccessUrl("/");
//
//
////        http
////                .authorizeRequests(a -> a
////                        .antMatchers("/", "/error", "/webjars/**").permitAll()
////                        .anyRequest().authenticated()
////                )
////                .exceptionHandling(e -> e
////                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
////                )
////                .oauth2Login()
////                .logout(l -> l
////                .logoutSuccessUrl("/").permitAll()
////        ).csrf(c -> c
////                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
////                ).oauth2Login(o -> o
////                        .failureHandler((request, response, exception) -> {
////                            request.getSession().setAttribute("error.message", exception.getMessage());
////                            handler.onAuthenticationFailure(request, response, exception);
////                        })
////                );
//
//        http
//                .antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//                .and()
//                .oauth2Login();
//
//        return http.build();
//    }
//
////    @Bean
////    public PersistentTokenRepository persistentTokenRepository(){
////        JdbcTokenRepositoryImpl tokenRepository =  new JdbcTokenRepositoryImpl();
////        tokenRepository.setDataSource(dataSource);
////        System.out.println(tokenRepository);
////        return tokenRepository;
////    }
////
////
////    @Autowired
////    private CustomOauth2UserService oAuth2UserService;

}
