package dev.shulika.xtelweb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequiredArgsConstructor
@Slf4j
public class MainController {
    @GetMapping("/")
    public String mainPage(Model model) {
        log.info("+++++ IN MainController :: mainPage :: START +++++");
        model.addAttribute("title", "Главная :: X-Tel");
        model.addAttribute("h1", "Главная");
        log.info("+++++ IN MainController :: mainPage :: COMPLETE +++++");
        return "index";
    }
}
