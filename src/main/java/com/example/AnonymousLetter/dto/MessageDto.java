package com.example.AnonymousLetter.dto;

import com.example.AnonymousLetter.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
public class MessageDto {
    private Long id;
    private String content; // 메시지 본문
    private LocalDateTime createdAt;
    private Member userId;
    private String emoji;
}
