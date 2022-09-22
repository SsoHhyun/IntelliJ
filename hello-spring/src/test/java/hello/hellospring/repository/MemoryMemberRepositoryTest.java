package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

// TDD: 테스트 주도 개발 -> 테스트 먼저 만들고, 구현 클래스 만들어 돌려보기
// 이 경우는 TDD는 아니다
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    
    // 테스트 끝날 때마다 데이터 지워주는 코드가 필요함
    // 테스트는 서로 의존 관계 없이 실행이 되어야 함.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

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

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("JWY");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("AYJ");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
