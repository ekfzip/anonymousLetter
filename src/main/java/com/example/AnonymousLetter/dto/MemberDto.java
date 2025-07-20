package com.example.AnonymousLetter.dto;

import com.example.AnonymousLetter.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
public class MemberDto {
    private Long id;
    private String userId;
    private String name;
    private String password;
    private int totalMessage;
    public Member toEntity(){
        return new Member(null, userId, name, password, 0);
    }
}
