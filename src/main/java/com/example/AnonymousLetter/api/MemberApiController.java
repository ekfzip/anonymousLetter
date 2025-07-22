package com.example.AnonymousLetter.api;

import com.example.AnonymousLetter.Service.MemberService;
import com.example.AnonymousLetter.dto.LoginDto;
import com.example.AnonymousLetter.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MemberApiController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/api/check-id")
    public ResponseEntity<Boolean> checkId(@RequestParam String userId){
        log.info(userId);
        boolean isDuplicate = memberService.isUseableId(userId);
        return ResponseEntity.ok(isDuplicate);
    }
    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody MemberDto dto){
        memberService.register(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PostMapping("/api/login")
    public ResponseEntity<?> login(HttpServletRequest request, @RequestBody LoginDto dto){
        log.info("userId = {}", dto.getUserId());
        log.info("password = {}", dto.getPassword());
        if(memberService.isValidUser(request, dto.getUserId(), dto.getPassword())){
            return ResponseEntity.ok(("로그인 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 틀렸습니다");
        }
    }
}
