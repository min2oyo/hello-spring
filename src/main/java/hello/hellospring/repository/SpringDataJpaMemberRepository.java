package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);   // JPQL: select m from Member m where m.name = ?
//    Optional<Member> findByNameAAndId(String name, Long id);  // 위 코드의 확장형
}
