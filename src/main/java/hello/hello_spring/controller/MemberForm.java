package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// 웹 등록 화면에서 데이터를 전달 받을 폼 객체
public class MemberForm {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
}
