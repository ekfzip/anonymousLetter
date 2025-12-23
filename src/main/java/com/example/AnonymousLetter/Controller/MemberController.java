package com.example.AnonymousLetter.Controller;

import com.example.AnonymousLetter.Repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MemberController {

    @GetMapping("/main/register")
    public String register(){
        return "register";
    }
    @GetMapping("/main/login")
    public String login(){
        return "login";
    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
