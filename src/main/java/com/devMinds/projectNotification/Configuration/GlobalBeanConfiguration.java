package com.devMinds.projectNotification.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
public class GlobalBeanConfiguration {

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resourceTemplateResolver = new SpringResourceTemplateResolver();
        resourceTemplateResolver.setPrefix("classpath:templates/");
        resourceTemplateResolver.setSuffix(".html");
        resourceTemplateResolver.setCacheable(false);
        resourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
        return resourceTemplateResolver;
    }
}
