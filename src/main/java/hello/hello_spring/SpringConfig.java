package hello.hello_spring;

import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    /*
    JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행
    JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환 할 수 있다
    JPA를 사용하면 개발 생산성을 크게 높일 수 있다
     */
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemorymemberRepository();
//        return new JdbcMemberRepository(dataSource);
        // JdbcTemplate을 사용하도록 스프링 설정 변경
//        return  new JdbcTemplateMemberRepository(dataSource);
        // JPA를 사용하도록 스프링 설정 변경
        return new JpaMemberRepository(em);
    }
}



