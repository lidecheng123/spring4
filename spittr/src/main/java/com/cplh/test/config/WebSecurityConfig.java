package com.cplh.test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private DataSource dataSource;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http
      .authorizeRequests()
          .antMatchers("/themes/**", "/assets/**", "/components/**").permitAll()
          .anyRequest().authenticated()
      .and()
      	  .formLogin()
          .loginPage("/login")          
          .permitAll()
      .and()
	      .logout()
          .permitAll();
   
  }
//  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        .withUser("user").password(new BCryptPasswordEncoder().encode("password")).roles("USER");
//	  auth.jdbcAuthentication().dataSource(dataSource)
//	  .usersByUsernameQuery("select username, password, true " +"from Spitter where username=?")
//	  .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
//	  .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
  }

  
}
