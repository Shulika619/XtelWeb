package dev.shulika.xtelweb.controller;

import dev.shulika.xtelweb.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public String mainPostPage(
            Model model,
            @PageableDefault(size = 15) @SortDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        log.info("+++++ IN PostController :: mainPostPage :: START +++++");
        var posts = postService.findAll(pageable);
        model.addAttribute("title", "Список сообщений :: X-Tel");
        model.addAttribute("posts", posts);
        log.info("+++++ IN PostController :: mainPostPage :: COMPLETE +++++");
        return "index";
    }

    @GetMapping("/posts/{pageNumber}")
    public String postPageNumber(
            @PathVariable("pageNumber") Integer currentPage,
            Model model,
            @PageableDefault(size = 10) @SortDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        log.info("+++++ IN PostController :: postPageNumber :: START +++++");
        var posts = postService.findAll(pageable);
        model.addAttribute("posts", posts);
        log.info("+++++ IN PostController :: postPageNumber :: COMPLETE +++++");
        return "index";
    }

}