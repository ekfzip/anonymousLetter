package com.example.AnonymousLetter.Controller;

import com.example.AnonymousLetter.Service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class MessageController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/{userId}")
    public String myPage(@PathVariable String userId, HttpSession session, Model model) {

        try{
            // 로그인 된 사용자의 마이 페이지일 때
            if (session.getAttribute("userId").toString().equals(userId)) {
                model.addAttribute("name", memberService.getMemberInfo(userId).getName().substring(1));
                model.addAttribute("totalMessage", memberService.getMemberInfo(userId).getTotalMessage());
                return "mypage";
            }
            // 남의 페이지 들어갔을 때
            else {
                model.addAttribute("name", memberService.getMemberInfo(userId).getName().substring(1));
                model.addAttribute("totalMessage", memberService.getMemberInfo(userId).getTotalMessage());
                return "goWriteMsg";
            }
        }catch (NullPointerException e){
            // 로그인 안 됐을 때
            model.addAttribute("name", memberService.getMemberInfo(userId).getName().substring(1));
            model.addAttribute("totalMessage", memberService.getMemberInfo(userId).getTotalMessage());
            return "goWriteMsg";
        }
    }
    @GetMapping("/{userId}/write")
    public String WritePage(@PathVariable String userId){
        return "write";
    }
}
