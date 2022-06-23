package org.strongcom.study.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.strongcom.study.hellospring.service.MemberService;

@Controller     //어노테이션 보고 스프링이 관리해야한다는걸 안다.
public class MemberController {
    private final MemberService memberService;

    @Autowired  //스프링 컨테이너에서 가져온다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
