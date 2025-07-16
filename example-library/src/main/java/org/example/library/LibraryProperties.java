package org.example.library;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;

/**
 * Configuration properties definition for example library
 * @param enabled Whether some feature is enabled or not, defaults to true
 * @param timeout Duration for some timed feature, defaults to 5 seconds. Values can be
 *                specified in several formats, including; "{value}{unit}" where "{unit}"
 *                can be any of "d (days), h (hours), m (minutes), s (seconds), ms (millis),
 *                us (micros), ns (nanos)". For other formats see the Spring Boot documentation:
 *                <a href="https://docs.spring.io/spring-boot/reference/features/external-config.html#features.external-config.typesafe-configuration-properties.conversion.durations">
 *                Externalized Configuration - Converting Durations</a>
 */
@ConfigurationProperties("example-library")
public record LibraryProperties(
        @DefaultValue("true") Boolean enabled,
        @DefaultValue("5s")   Duration timeout
) {}
