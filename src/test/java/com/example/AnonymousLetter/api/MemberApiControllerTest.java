package com.example.AnonymousLetter.api;

import com.example.AnonymousLetter.Service.MemberService;
import com.example.AnonymousLetter.dto.LoginDto;
import com.example.AnonymousLetter.dto.MemberDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(MemberApiController.class)
class MemberApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void register() throws Exception{
        MemberDto dto = new MemberDto(null, "test", "테스터", "1234", 0);

        String dtoToJSON = objectMapper.writeValueAsString(dto);

        // MemberService.register()는 void라 굳이 when().thenReturn() 필요 없음
        mockMvc.perform(post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dtoToJSON))
                .andExpect(status().isOk())
                .andExpect(content().json(dtoToJSON)); // 문자열 비교 대신 JSON 구조 비교
    }

    @Test
    void login_success() throws Exception{
        LoginDto dto = new LoginDto("test", "1234");

        when(memberService.isValidUser(any(HttpServletRequest.class), eq("test"), eq("1234")))
                .thenReturn(true);

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("로그인 성공"));

    }
    @Test
    void login_fail() throws Exception{
        LoginDto dto = new LoginDto("test", "1234");

        when(memberService.isValidUser(any(HttpServletRequest.class), eq("test1"), eq("1234")))
                .thenReturn(true);

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("아이디 또는 비밀번호가 틀렸습니다"));

    }
}