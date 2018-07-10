package com.cplh.test.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;


@Configuration
@ComponentScan(basePackages="com.cplh.test")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{
	
//	@Bean
//	public ViewResolver viewResolver(){
//		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/views/");
//		viewResolver.setSuffix(".jsp");
//		viewResolver.setExposeContextBeansAsAttributes(true);
//		return viewResolver;
//	}
//	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandling){
		defaultServletHandling.enable();
	}
	
	@Bean
	public ViewResolver viewResolver(TemplateEngine template){
		ThymeleafViewResolver tlViewResolver=new ThymeleafViewResolver();
		tlViewResolver.setTemplateEngine(template);
		tlViewResolver.setCharacterEncoding("UTF-8");

		return tlViewResolver;
	}
	
	 @Bean
	  public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    templateEngine.addDialect(new SpringSecurityDialect());
	    return templateEngine;
	  }

	  @Bean
	  public ITemplateResolver templateResolver() {
		  SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	    templateResolver.setPrefix("/WEB-INF/views/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode("HTML");
	    templateResolver.setCacheable(false);
	    return templateResolver;
	  }
	  
	  @Bean
	  public MultipartResolver multipartResolver() throws IOException {
		return new StandardServletMultipartResolver();
	  }
	
}
