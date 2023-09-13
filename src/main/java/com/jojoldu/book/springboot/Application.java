package com.jojoldu.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 스프링부투의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정 , 특히나 @SpringBootAppliaction이 있는 위치부터 설정
// 을 읽어가기 때문에 이 클래스는 항상 프로그젝의 최상단에 위치해야 합니다.
// main Method에서 실행하는 SpringAPplication.run으로 인해 내장 WAS를 실행

/**
 *  내장 WAS란 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 실행
 *  이렇게 되면 항상 서버에 톰캣을  설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar 파일로 실행
 *  스프링부트에선 내장 WAS를 사용할 수 있는 것은 아니지만, 스프링부트에서는 내장 WAS를 사용하는 것을 권장
 *  WHY > 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문에
 */

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
