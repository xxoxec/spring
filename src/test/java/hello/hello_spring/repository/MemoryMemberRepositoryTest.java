package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*; // option+enter, Assertions 없애줌

class MemoryMemberRepositoryTest {

    MemorymemberRepository repository = new MemorymemberRepository();

    @AfterEach
    /*
    `@AfterEach` : 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다.
    이렇게 되면 다음 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다.
    `@AfterEach` 를 사용하면 각 테스트가 종료 될 때 마다 이 기능을 실행한다.
    여기서는 메모리 DB에 저장된 데이터를 삭제한다.
    테스트는 각각 독립적으로 실행되어야 하며 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아니다.
     */
    public void afterEach() {
        repository.clearStore(); // 테스트시마다 이 기능을 실행, 메모리 DB에 저장된 데이터를 삭제
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring"); // comment+shift+enter

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result == member));
        // Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result); // member가 result랑 똑같다
    }

    @Test
    public void findByName() {
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

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
