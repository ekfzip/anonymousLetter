package com.example.AnonymousLetter.Service;

import com.example.AnonymousLetter.Repository.MemberRepository;
import com.example.AnonymousLetter.Repository.MessageRepository;
import com.example.AnonymousLetter.dto.MessageDto;
import com.example.AnonymousLetter.entity.Member;
import com.example.AnonymousLetter.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public void send(MessageDto dto) {
        Member member = memberRepository.findByUserId(dto.getUserId());
        Message message = dto.sendMessage(member);
        member.increaseTotalMessage();
        messageRepository.save(message);
    }
}
