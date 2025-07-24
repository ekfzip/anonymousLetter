package com.example.AnonymousLetter.Repository;

import com.example.AnonymousLetter.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class MemberRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(MemberRepositoryTest.class);
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("사용하려는 아이디를 가진 유저가 있는지 확인")
    void existsByUserId() {
        Member member = new Member(null, "abc123", "김하나", "1234", 0);
        memberRepository.save(member);

        boolean isExistedId = memberRepository.existsByUserId("abc123");
        Assertions.assertTrue(isExistedId, "아이디가 존재함");
    }
    @Test
    @DisplayName("존재하지 않는 아이디는 false를 반환")
    void existsByUserId_notExist() {
        boolean exists = memberRepository.existsByUserId("abc12");
        Assertions.assertFalse(exists);
    }

    @Test
    @DisplayName("userId를 통해 검색하고 유저 정보를 불러옴")
    void findByUserId() {
        Member member = new Member(null, "abc123", "김하나", "1234", 0);
        memberRepository.save(member);

        Member m = memberRepository.findByUserId("abc123");
        log.info(m.toString());
    }
}