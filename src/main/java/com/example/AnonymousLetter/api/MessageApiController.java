package com.example.AnonymousLetter.api;

import com.example.AnonymousLetter.Service.MessageService;
import com.example.AnonymousLetter.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageApiController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/api/send")
    public ResponseEntity<?> send(@RequestBody MessageDto dto){
        System.out.println(dto.toString());
        messageService.send(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
