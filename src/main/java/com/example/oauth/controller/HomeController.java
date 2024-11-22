package com.example.oauth.controller;

import com.example.oauth.config.auth.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HttpSession session;

    @GetMapping("/")
    public String index(Model model) {
        SessionUser user = (SessionUser) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user.getName());
        }

        return "index";
    }
}
