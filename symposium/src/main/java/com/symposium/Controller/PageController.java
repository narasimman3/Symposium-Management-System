package com.symposium.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/admin")
    public String adminPage(){
        return "index"; // adminregister.html
    }

    @GetMapping("/user")
    public String userPage() {
        return "index"; // user.html
    }

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration"; // registration.html
    }

    @GetMapping("/event")
    public String eventPage() {
        return "event"; // event.html
    }

    @GetMapping("/result")
    public String resultPage() {
        return "result"; // result.html
    }

    @GetMapping("/feedback")
    public String feedbackPage() {
        return "feedback"; // feedback.html
    }
    @GetMapping("/index")
    public String home() {
        return "index"; // name of your HTML file in src/main/resources/templates
    }
}

