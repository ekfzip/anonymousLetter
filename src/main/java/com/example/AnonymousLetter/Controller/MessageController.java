package com.example.AnonymousLetter.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class MessageController {
    @GetMapping("/{userId}")
    public String myPage(@PathVariable String userId, Model model){
//        model.addAttribute("name", userId);
//        model.addAttribute("totalMessage", 0);
        return "mypage";
    }
}
