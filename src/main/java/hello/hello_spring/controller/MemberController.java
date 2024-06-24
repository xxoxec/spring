package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
/*
생성자에 `@Autowired` 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다.
이전 테스트에서는 개발자가 직접 주입했고, 여기서는 @Autowired에 의해 스프링이 주입해준다.
 */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /*
    스프링은 스프링 컨테이너에 스프링 빈을 등록할 떄, 기본으로 싱클톤으로 등록(유일하게 하나만 등록해서 공유)
    따라서 같은 스프링 빈이면 모두 같은 인스턴스
    설정으로 싱글톤이 아니게 설정할 수 있지만, 특별한 경우를 제외하면 대부분 싱글톤
     */
}
