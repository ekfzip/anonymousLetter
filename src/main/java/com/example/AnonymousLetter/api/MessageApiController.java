package com.example.AnonymousLetter.api;

import com.example.AnonymousLetter.Service.MessageService;
import com.example.AnonymousLetter.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MessageApiController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/api/send")
    public ResponseEntity<?> send(@RequestBody MessageDto dto){
       log.info(dto.toString());
        messageService.send(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @GetMapping("/api/messages/{userId}")
    public List<MessageDto> getMessages(@PathVariable String userId) {
        return messageService.getMessages(userId);
    }
}
