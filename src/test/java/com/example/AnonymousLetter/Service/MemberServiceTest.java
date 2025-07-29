package com.example.AnonymousLetter.Service;

import com.example.AnonymousLetter.Repository.MemberRepository;
import com.example.AnonymousLetter.dto.MemberDto;
import com.example.AnonymousLetter.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MemberServiceTest {

    private static final Logger log = LoggerFactory.getLogger(MemberServiceTest.class);
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("사용 가능한 아이디인 경우")
    void isUsableId_success() {
        String id = "test";
        boolean result = memberService.isUsableId(id);

        assertFalse(result, "사용 가능한 아이디");
    }
    @Test
    @DisplayName("이미 다른 유저가 사용 중인 아이디인 경우")
    void isUsableId_fail() {
        MemberDto memberDto = new MemberDto(null, "test", "테스터", "1234", 0);
        Member member = memberDto.toEntity();
        memberRepository.save(member);

        String testId = "test";
        boolean result = memberService.isUsableId(testId);
        assertTrue(result, "이미 존재하는 아이디");

    }
    @Test
    void register() {
        MemberDto memberDto = new MemberDto(null, "test", "테스터", "1234", 0);
        memberService.register(memberDto);

        Member test = memberRepository.findByUserId("test");
        log.info(test.toString());
    }

    @Test
    @DisplayName("로그인 성공")
    void login_success() {
        MemberDto memberDto = new MemberDto(null, "test", "테스터", "1234", 0);
        Member member = memberDto.toEntity();
        memberRepository.save(member);

        boolean result = memberService.login("test", "1234");
        assertTrue(result, "로그인 성공");
    }
    @Test
    @DisplayName("로그인 실패")
    void login_fail() {
        MemberDto memberDto = new MemberDto(null, "test", "테스터", "1234", 0);
        Member member = memberDto.toEntity();
        memberRepository.save(member);

        boolean result = memberService.login("test1", "1234");
        assertFalse(result, "로그인 실패");
    }
}