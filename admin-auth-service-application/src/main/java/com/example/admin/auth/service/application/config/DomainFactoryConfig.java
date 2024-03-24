package com.example.admin.auth.service.application.config;

import com.example.admin.auth.service.domain.factory.PermissionDomainFactory;
import com.example.admin.auth.service.domain.factory.PoliciesDomainFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainFactoryConfig {

    @Bean
    PermissionDomainFactory permissionDomainFactory() {
        return new PermissionDomainFactory();
    }

    @Bean
    PoliciesDomainFactory policiesDomainFactory() {
        return new PoliciesDomainFactory();
    }
}
