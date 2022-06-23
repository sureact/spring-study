package org.strongcom.study.hellospring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.strongcom.study.hellospring.domain.Member;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Optional<Member> fineMember = Optional.of(memberService.findOne(saveId).get());
        Assertions.assertThat(member.getName()).isEqualTo(findMembers().getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}