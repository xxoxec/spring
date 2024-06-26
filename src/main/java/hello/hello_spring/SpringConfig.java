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
    스프링 데이터 JPA가 `SpringDataJpaMemberRepository` 를 스프링 빈으로 자동 등록
    인터페이스를 통한 기본적인 CRUD
    findByName()` , `findByEmail()` 처럼 메서드 이름 만으로 조회 기능 제공
    페이징 기능 자동 제공
     */

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemorymemberRepository();
//        return new JdbcMemberRepository(dataSource);
        // JdbcTemplate을 사용하도록 스프링 설정 변경
//        return  new JdbcTemplateMemberRepository(dataSource);
        // JPA를 사용하도록 스프링 설정 변경
//        return new JpaMemberRepository(em);
//    }
}



