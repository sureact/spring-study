package repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.strongcom.study.hellospring.domain.Member;
import org.strongcom.study.hellospring.repository.MemberRepository;
import org.strongcom.study.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//테스트케이스는 순서에 의존적이면 안되기 때문에 테스트 끝날 때 마다 리포지토리 초기화하기
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        //new에서 넣은 것과 꺼낸 것이 동일하면 됨
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //repository.save(new Member("spring"));

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(result,member);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
    }
}
