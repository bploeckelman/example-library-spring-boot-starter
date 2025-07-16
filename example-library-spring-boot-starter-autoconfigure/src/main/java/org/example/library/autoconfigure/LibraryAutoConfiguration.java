package org.example.library.autoconfigure;

import org.example.library.LibraryProperties;
import org.example.library.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(LibraryService.class)
@EnableConfigurationProperties(LibraryProperties.class)
public class LibraryAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(LibraryAutoConfiguration.class);

    private final LibraryProperties properties;

    public LibraryAutoConfiguration(LibraryProperties properties) {
        this.properties = properties;
        // TODO: while it's helpful to log library autoconfig on startup,
        //  properties can contain sensitive values, so it's better to
        //  create/use LibraryProperties::toLogString() which sanitizes output
        log.info("example-library autoconfigured with properties: {}", properties);
    }

    @ConditionalOnMissingBean
    @Bean
    public LibraryService libraryService() {
        return new LibraryService(properties);
    }
}
