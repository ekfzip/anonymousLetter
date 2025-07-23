package com.example.AnonymousLetter.Repository;

import com.example.AnonymousLetter.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
