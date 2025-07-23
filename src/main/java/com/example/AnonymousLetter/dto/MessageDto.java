package com.example.AnonymousLetter.dto;

import com.example.AnonymousLetter.entity.Member;
import com.example.AnonymousLetter.entity.Message;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@Data
public class MessageDto {
    private Long id;
    private String content; // 메시지 본문
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    private String userId;
    private String emoji;

    public Message sendMessage(Member member){
        return new Message(null, content, createdAt, member, emoji);
    }
}
