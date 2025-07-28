package com.example.AnonymousLetter.Repository;

import com.example.AnonymousLetter.dto.MessageDto;
import com.example.AnonymousLetter.entity.Member;
import com.example.AnonymousLetter.entity.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class MessageRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    @DisplayName("유저에게 수신된 모든 메시지 불러옴")
    void findByUserId() {
        // 유저 생성 및 저장
        Member member = new Member(null, "test", "테스터", "password", 0);
        memberRepository.save(member);

        // 메시지 여러 개 저장
        Message msg1 = new Message(null, "첫 번째 메시지", LocalDateTime.now(), member, "😊");
        Message msg2 = new Message(null, "두 번째 메시지", LocalDateTime.now(), member, "💌");
        messageRepository.save(msg1);
        messageRepository.save(msg2);

        // 해당 유저의 메시지 검색
        List<MessageDto> messages = messageRepository.findByUserId(member);

        // 검증
        assertThat(messages).hasSize(2);
        assertThat(messages).extracting("content")
                .containsExactlyInAnyOrder("첫 번째 메시지", "두 번째 메시지");
    }
}