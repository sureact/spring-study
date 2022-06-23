package org.strongcom.study.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.strongcom.study.hellospring.repository.JdbcMemberRepository;
import org.strongcom.study.hellospring.repository.JdbcTemplateMemberRepository;
import org.strongcom.study.hellospring.repository.MemberRepository;
import org.strongcom.study.hellospring.repository.MemoryMemberRepository;
import org.strongcom.study.hellospring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JdbcMemberRepository(dataSource);
    }

}
