package com.example.AnonymousLetter.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@ToString
@NoArgsConstructor
public class LoginDto {
    private String userId;
    private String password;
}
