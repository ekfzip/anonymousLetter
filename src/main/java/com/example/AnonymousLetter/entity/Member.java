package com.example.AnonymousLetter.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private int totalMessage;
    public void increaseTotalMessage() {
        this.totalMessage += 1;
    }
}
