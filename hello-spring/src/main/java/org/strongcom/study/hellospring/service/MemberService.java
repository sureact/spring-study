package org.strongcom.study.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.strongcom.study.hellospring.domain.Member;
import org.strongcom.study.hellospring.repository.MemberRepository;
import org.strongcom.study.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Transactional      //JPA 쓸때는 항상 해주기(데이터를 저장하거나 변경할 때)
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //이름이 같은 회원이 존재 x
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
