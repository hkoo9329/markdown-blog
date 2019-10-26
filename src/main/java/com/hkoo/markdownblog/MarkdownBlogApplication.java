package com.hkoo.markdownblog;

import com.hkoo.markdownblog.resolver.UserArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@SpringBootApplication
public class MarkdownBlogApplication implements WebMvcConfigurer {

    @Autowired
    private UserArgumentResolver userArgumentResolver;

    public static void main(String[] args) {
        SpringApplication.run(MarkdownBlogApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolver);
    }
}
