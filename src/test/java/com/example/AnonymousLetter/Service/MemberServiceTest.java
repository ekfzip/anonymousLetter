package com.example.AnonymousLetter.Service;

import com.example.AnonymousLetter.Repository.MemberRepository;
import com.example.AnonymousLetter.dto.MemberDto;
import com.example.AnonymousLetter.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    @DisplayName("아이디 중복 확인")
    void isUseableId_exists() {
        String userId = "testUser";
        when(memberRepository.existsByUserId(userId)).thenReturn(true);

        boolean result = memberService.isUseableId(userId);

        assertThat(result).isTrue();
        verify(memberRepository, times(1)).existsByUserId(userId);
    }

    @Test
    @DisplayName("회원가입 성공 테스트")
    void register_success() {

        MemberDto memberDto = new MemberDto(null, "test", "테스터", "1234", 0);

        memberService.register(memberDto);

        verify(memberRepository, times(1)).save(any(Member.class));
    }

    @Test
    void login() {
        MemberDto memberDto = new MemberDto(null, "test", "테스터", "1234", 0);
        Member member = memberDto.toEntity();

        when(memberRepository.findByUserId(member.getUserId())).thenReturn(member);

        boolean isLogin = memberService.login(member.getUserId(), member.getPassword());

        Assertions.assertTrue(isLogin, "유저 정보 존재");
    }

    @Test
    void isValidUser() {
    }

    @Test
    void getMemberInfo() {
    }
}