package com.bezkoder.spring.security.login;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class CorsConfig {
	
//	@Bean   
//	public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override           
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("http://localhost:4200")
//                    .allowCredentials(true);
//            }
//        };
//    }
	 @Bean
	    public CorsFilter corsFilter() {
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "responseType", "Authorization"));
	        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }   

  
}
