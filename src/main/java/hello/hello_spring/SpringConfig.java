package hello.hello_spring;

import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemorymemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemorymemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}

/*
DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체다.
스프링 부트는 데이터베이스 커넥션 정 보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둔다
그래서 DI를 받을 수 있다.

개방-폐쇄 원칙(OCP, Open-Closed Principle) - 확장에는 열려있고, 수정, 변경에는 닫혀있다.
스프링의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경 할 수 있다.
데이터를 DB에 저장하므로 스프링 서버를 다시 실행해도 데이터가 안전하게 저장된다.
 */


