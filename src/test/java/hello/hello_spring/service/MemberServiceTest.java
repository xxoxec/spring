package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemorymemberRepository;
import org.assertj.core.api.Assertions; // assertThat
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*; // assertThat
import static org.junit.jupiter.api.Assertions.*;

// commend+shift+t
class MemberServiceTest {

    /*
    MemberService memberService = new MemberService();
    MemorymemberRepository memberRepository = new MemorymemberRepository();
     */

    MemberService memberService;
    MemorymemberRepository memberRepository;

    /*
    같은 MemberRepository 사용 가능
    @BeforeEach: 각 테스트 실행 전 호출
    테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 의존관계도 새로 맺어줌
     */
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemorymemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    // 테스트는 한글로 작성 가능
    @Test
    void 회원가입() {
        //given ~상황이 주어졌을때, 이 데이터를 기반으로
        Member member = new Member();
        member.setName("hello");

        //when ~실행하면, 검증하는구간
        Long saveId = memberService.join(member);

        //then ~이렇게나옴(결과), 검증부
        Member findMember = memberService.findOne(saveId).get();
        // option+enter, Assertions
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
       /*
       comment+option+/
       try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}