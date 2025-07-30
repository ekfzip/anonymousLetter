package com.example.AnonymousLetter.dto;

import lombok.*;

@Data
@Getter
@ToString
@AllArgsConstructor
public class LoginDto {
    private String userId;
    private String password;
}
