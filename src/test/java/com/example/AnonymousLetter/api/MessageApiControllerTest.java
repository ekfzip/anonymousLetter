package com.example.AnonymousLetter.api;

import com.example.AnonymousLetter.Service.MemberService;
import com.example.AnonymousLetter.Service.MessageService;
import com.example.AnonymousLetter.dto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(MessageApiController.class)
class MessageApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void send() throws Exception {
        MessageDto messageDto = new MessageDto(null, "hi", LocalDateTime.now(), "test", "😍");

        String dtoToJSON = objectMapper.writeValueAsString(messageDto);

        mockMvc.perform(post("/api/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dtoToJSON))
                .andExpect(status().isOk())
                .andExpect(content().json(dtoToJSON));
    }

    @Test
    void getMessages() throws Exception {
        // given
        String userId = "test";
        List<MessageDto> expectedMessages = List.of(
                new MessageDto(1L, "hello", LocalDateTime.now(), userId, "📩"),
                new MessageDto(2L, "hi", LocalDateTime.now(), userId, "🍀")
        );

        when(messageService.getMessages(userId)).thenReturn(expectedMessages);

        // when & then
        mockMvc.perform(get("/api/messages/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedMessages)));
    }
}