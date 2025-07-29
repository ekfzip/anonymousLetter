package com.example.AnonymousLetter.Service;

import com.example.AnonymousLetter.Repository.MemberRepository;
import com.example.AnonymousLetter.Repository.MessageRepository;
import com.example.AnonymousLetter.dto.MemberDto;
import com.example.AnonymousLetter.dto.MessageDto;
import com.example.AnonymousLetter.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MessageServiceTest {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceTest.class);
    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("메시지 전송 성공")
    void send_success() {
        MemberDto memberDto = new MemberDto(null, "test", "테스터", "1234", 0);
        Member member = memberDto.toEntity();
        memberRepository.save(member);

        MessageDto messageDto = new MessageDto(null, "hi", LocalDateTime.now(), "test", "😍");
        messageService.send(messageDto);

        log.info(messageDto.toString());
    }

    @Test
    @DisplayName("특정 유저에게 온 메시지 불러오기")
    void getMessages() {

        send_success();

        List<MessageDto> messageDtoList = messageService.getMessages("test");
        log.info(messageDtoList.toString());
    }
}