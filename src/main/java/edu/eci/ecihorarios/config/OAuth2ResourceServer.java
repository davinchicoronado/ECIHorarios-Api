/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.config;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
/**
 *
 * @author David Coronado
 */ 
@Configuration 
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter{
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        	http
	.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/error**").permitAll();
	 //.anyRequest().authenticated();
        
         http.requestMatchers().antMatchers("/")
                 .and().authorizeRequests().antMatchers("/").hasAuthority("USER")
                 .and().requestMatchers().antMatchers("/private")
                 .and().authorizeRequests().antMatchers("/private").hasAuthority("ADMIN")
                 .and().requestMatchers().antMatchers("/ecihorarios/user/**")
                 .and().authorizeRequests().antMatchers("/ecihorarios/user/**").hasAnyAuthority("USER","ADMIN")
                 .and().requestMatchers().antMatchers("/ecihorarios/curriculum/**") 
                 .and().authorizeRequests().antMatchers("/ecihorarios/curriculum/**").hasAnyAuthority("USER","ADMIN")
                 .and().requestMatchers().antMatchers("/ecihorarios/subject/**") 
                 .and().authorizeRequests().antMatchers("/ecihorarios/subject/**").hasAnyAuthority("USER","ADMIN") 
                 .and().requestMatchers().antMatchers("/ecihorarios/availablesubject/**") 
                 .and().authorizeRequests().antMatchers("/ecihorarios/availablesubject/**").hasAnyAuthority("USER","ADMIN")
                 .and().requestMatchers().antMatchers("/ecihorarios/schedule/**") 
                 .and().authorizeRequests().antMatchers("/ecihorarios/schedule/**").hasAnyAuthority("USER","ADMIN");
                 
         
    }
    
    

    
    
}
