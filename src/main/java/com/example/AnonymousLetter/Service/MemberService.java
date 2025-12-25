package com.example.AnonymousLetter.Service;

import com.example.AnonymousLetter.Repository.MemberRepository;
import com.example.AnonymousLetter.dto.MemberDto;
import com.example.AnonymousLetter.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Slf4j
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean isUsableId(String userId) {
        return memberRepository.existsByUserId(userId);
    }
    @Transactional
    public void register(MemberDto dto) {
        Member member = dto.toEntity();
        log.info(dto.toString());
        memberRepository.save(member);
    }

    public boolean login(String userId, String password) {
        Member member = memberRepository.findByUserId(userId);
        if(member == null) return false;
        return member.getPassword().equals(password);
    }

    public boolean isValidUser(HttpServletRequest request, String userId, String password) {
        Optional<Member> optionalMember = Optional.ofNullable(memberRepository.findByUserId(userId));
        if(optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (member.getPassword().equals(password)) {
                // 로그인 성공: 세션에 userId 저장
                HttpSession session = request.getSession(true);
                session.setAttribute("userId", userId);
                log.info(session.getAttribute("userId").toString());
                return true;
            }
        }
        return false;
    }
    public Member getMemberInfo(String userId) {
        Member member = memberRepository.findByUserId(userId);

        if (member == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "해당 userId를 가진 회원이 없습니다: " + userId);
        }

        return member;
    }
}
