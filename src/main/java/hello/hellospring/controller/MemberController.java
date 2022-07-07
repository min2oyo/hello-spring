package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링이 뜰 때 스프링 컨테이너가 생기고 아래 객체를 생성해서 담아두고 관리함
public class MemberController {
    private final MemberService memberService;

    @Autowired  // memberService를 컨테이너에 있는 memberService를 가져다 매칭 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }




}
