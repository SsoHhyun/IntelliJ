package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("KSH");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // 확인 방법 1
        // System.out.println("result = " + (result == member));
        // 확인 방법 2
        //Assertions.assertEquals(member, result);
        // 확인 방법 3
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("KSH");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("JWY");
        repository.save(member2);

        // get을 쓰면 Optional을 깔 수 있다고 한다
        Member result = repository.findByName("KSH").get();
        assertThat(result).isEqualTo(member1);
    }

}
