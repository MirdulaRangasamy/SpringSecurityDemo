package com.gmail.example.configuartion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecuirtyConfiguration {
	
	//With WebSecurityConfigurerAdapter declaring User's 
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("user1").password("password").roles(
	 * "ADMIN");
	 * auth.inMemoryAuthentication().withUser("user2").password("password").roles(
	 * "USER"); }
	 */
	
	//WithOut WebSecurityConfigurerAdapter declaring User's 
	  @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user = User.withUsername("mirdu")
	            .password("abc")
	            .roles("USER")
	            .build();
	        UserDetails user1 = User.withUsername("mirdu1")
		            .password("abc1")
		            .roles("ADMIN")
		            .build();
	        return new InMemoryUserDetailsManager(user,user1);
	    }

	//With WebSecurityConfigurerAdapter All Requests Authenticated
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	 * }
	 */
	
	//With WebSecurityConfigurerAdapter Request with specified URL pattern are authenticated
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().
	 * httpBasic(); }
	 */
	
	//With WebSecurityConfigurerAdapter Request with specified URL and having role as ADMIN are authenticated
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().antMatchers("/noauth/**").permitAll().and().
	 * authorizeHttpRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").
	 * anyRequest().authenticated().and().httpBasic(); }
	 */
	
	//WithOut WebSecurityConfigurerAdapter Request with specified URL and having role as ADMIN are authenticated
	
	  @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	  Exception { http.csrf().disable();
	  http.authorizeRequests().antMatchers("/noauth/**").permitAll().and().
	  authorizeHttpRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").
	  anyRequest().authenticated().and().httpBasic(); return http.build(); }
	 
	 
	
	//WithOut WebSecurityConfigurerAdapter Request with specified URL pattern are authenticated
	
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws //
	 * Exception { http.csrf().disable(); //
	 * http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().
	 * httpBasic(); return http.build(); }
	 */
	 	 
	 
	 
	//WithOut WebSecurityConfigurerAdapter All Requests Authenticated
	
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception { http.csrf().disable();
	 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	 * return http.build(); }
	 */
	 
	 
	 
	
	@Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return  (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
    }
	
}
