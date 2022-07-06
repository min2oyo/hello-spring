package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // 회원 검색
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 모든 회원 조회
}
