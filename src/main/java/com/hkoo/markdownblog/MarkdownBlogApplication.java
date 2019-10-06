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

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception {
        return (args) -> {
            User user = userRepository.save(User.builder()
                    .name("havi")
                    .password("test")
                    .email("havi@gmail.com")
                    .createdDate(LocalDateTime.now())
                    .build());

            IntStream.rangeClosed(1, 200).forEach(index ->
                    boardRepository.save(Board.builder()
                            .title("게시글"+index)
                            .content("컨텐츠")
                            .createdDate(LocalDateTime.now())
                            .updatedDate(LocalDateTime.now())
                            .user(user).build())
            );
        };
    }

}
