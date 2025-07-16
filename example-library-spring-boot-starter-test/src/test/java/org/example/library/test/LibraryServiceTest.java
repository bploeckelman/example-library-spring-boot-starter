package org.example.library.test;

import org.example.library.LibraryService;
import org.example.library.autoconfigure.LibraryAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryServiceTest {

    @Configuration // NOTE: @TestConfiguration doesn't work, it's ignored!
    @ImportAutoConfiguration(LibraryAutoConfiguration.class)
    static class TestConfig {}

    @Autowired
    private LibraryService libraryService;

    @Test
    void libraryServiceIsAvailable() {
        assertNotNull(libraryService);
    }

    @Test
    void libraryServiceCallSucceeds() {
        var result = assertDoesNotThrow(() -> libraryService.getAfterTimeout());
        assertEquals("Hello!", result);
    }
}
