package org.example.library.demo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.library.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

    private final LibraryService libraryService;

    public ApiController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @SneakyThrows
    @GetMapping("/tests/timeout")
    public String testTimeout() {
        return CompletableFuture.supplyAsync(libraryService::getAfterTimeout).get();
    }
}
