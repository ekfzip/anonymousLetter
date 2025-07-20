package com.example.AnonymousLetter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String content; // 메시지 본문
    @Column
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "receiver")
    private Member userId;
    private String emoji;
}
