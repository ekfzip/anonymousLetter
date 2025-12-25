package com.example.AnonymousLetter.Repository;

import com.example.AnonymousLetter.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // @Query(value = "SELECT COUNT(*) FROM member WHERE userId = :userId")
    boolean existsByUserId(String userId);
    Member findByUserId(String userId);

}
