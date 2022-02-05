package com.bewithme.app.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@ComponentScan
@EnableJpaAuditing
public class WebMvcConfig implements WebMvcConfigurer{

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { 
			"classpath:/static/", "classpath:/public/", "classpath:/templates/",
			"classpath:/resources/", "classpath:/META-INF/resources/"
	};
	
	private ApplicationContext context;
	  
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}
	
	@Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(this.context);
        resolver.setPrefix("classpath:templates/");
	    resolver.setSuffix(".html");
	    resolver.setTemplateMode(TemplateMode.HTML);
	    resolver.setCacheable(false);
	    resolver.setCheckExistence(false);
	    resolver.setCharacterEncoding("UTF-8");
	    return resolver;
	}
	
	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine() {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.addDialect(new LayoutDialect());
	    templateEngine.addDialect(new SpringSecurityDialect());
	    templateEngine.setTemplateResolver(this.thymeleafTemplateResolver());
	    return templateEngine;
	}
	
	
	
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(this.thymeleafTemplateEngine());
	    viewResolver.setCharacterEncoding("UTF-8");
	    return viewResolver;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	    registry.viewResolver(this.thymeleafViewResolver());
	}
}
