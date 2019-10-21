package com.hkoo.markdownblog;

import com.hkoo.markdownblog.domain.Board;
import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.repository.BoardRepository;
import com.hkoo.markdownblog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class MarkdownBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkdownBlogApplication.class, args);
    }

}
