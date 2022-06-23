package org.strongcom.study.hellospring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.strongcom.study.hellospring.domain.Member;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        assertThat(member.getName()).isEqualTo(fineMember.get().getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}