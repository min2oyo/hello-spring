package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach // 동작하기 전 작업
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    
    @AfterEach  // 메서드 실행이 끝날 때마다 어떤 동작을 함. 골백 메서드
    public void afterEach() {
        memberRepository.clearStore();
    }

    // 회원가입
    @Test
    void join() {
        // given: 상황이 주어짐 (이 데이터를 기반으로 하는구나)
        Member member = new Member();
        member.setName("hello");

        // when: 실행했을 때 (이것을 검증하는구나)
        Long saveId = memberService.join(member);

        // then: 이런 결과가 나와야 함 (검증 부분이다)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ");

//                try {
//            memberService.join(member2);
//            fail("정상");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ");
//        }


        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}