package com.example.AnonymousLetter.Repository;

import com.example.AnonymousLetter.dto.MessageDto;
import com.example.AnonymousLetter.entity.Member;
import com.example.AnonymousLetter.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT new com.example.AnonymousLetter.dto.MessageDto(m.id, m.content, m.createdAt, m.userId.userId, m.emoji) " +
            "FROM Message m WHERE m.userId = :member")
    List<MessageDto> findByUserId(@Param("member") Member member);
}
