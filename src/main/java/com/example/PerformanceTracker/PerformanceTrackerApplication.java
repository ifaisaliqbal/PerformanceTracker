package com.example.PerformanceTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PerformanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceTrackerApplication.class, args);
	}
        
        
//   @Bean
//   public WebMvcConfigurer corsConfigurer() {
//      return new WebMvcConfigurerAdapter() {
//         public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/products").allowedOrigins("http://localhost:8080");
//         }
//      };
//   }

}
