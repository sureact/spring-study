package org.strongcom.study.hellospring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.strongcom.study.hellospring.domain.Member;
import org.strongcom.study.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    //clear 해주고싶은데 service밖에 없음. 그래서 리포지토리 가져옴
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Optional<Member> fineMember = Optional.of(memberService.findOne(saveId).get());
        assertThat(member.getName()).isEqualTo(fineMember.get().getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member("spring");
        Member member2 = new Member("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test
    void findOne() {
    }
}