package org.example.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class LibraryService {

    private static final Logger log = LoggerFactory.getLogger(LibraryService.class);

    private final Duration timeout;

    public LibraryService(LibraryProperties properties) {
        this.timeout = properties.timeout();
    }

    public String getAfterTimeout() throws InterruptedException {
        log.info("Getting service data in {}", timeout);
        Thread.sleep(timeout); // simulate long-running task to get value
        log.info("Timeout for {} completed", timeout);
        return "Hello!";
    }
}
