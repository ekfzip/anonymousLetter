package com.example.AnonymousLetter.api;

import com.example.AnonymousLetter.Service.MemberService;
import com.example.AnonymousLetter.dto.MemberDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(MemberApiController.class)
class MemberApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void checkId() {
    }

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
    void login() {
    }
}