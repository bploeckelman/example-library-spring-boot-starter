package org.example.library.demo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.library.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

    private final LibraryService libraryService;

    public record ApiResponse(String message) {}

    public ApiController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/tests/timeout")
    @SneakyThrows
    public Callable<ApiResponse> testTimeout() {
        log.info("Handling '/tests/timeout' request in thread: '{}'", Thread.currentThread().getName());
        return () -> {
            log.info("Making 'getAfterTimeout()' service call in thread: '{}'", Thread.currentThread().getName());
            return new ApiResponse(libraryService.getAfterTimeout());
        };
    }
}
