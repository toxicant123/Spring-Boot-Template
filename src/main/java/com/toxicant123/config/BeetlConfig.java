package com.toxicant123.config;

import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-09 23:25
 */
@Configuration
public class BeetlConfig {

    @Bean
    public GroupTemplate getGroupTemplate() throws IOException {
        var stringTemplateResourceLoader = new StringTemplateResourceLoader();
        var configuration = org.beetl.core.Configuration.defaultConfiguration();
        configuration.setNativeCall(true);
        configuration.setNativeSecurity("org.beetl.core.DefaultNativeSecurityManager");
        return new GroupTemplate(stringTemplateResourceLoader, configuration);
    }
}
