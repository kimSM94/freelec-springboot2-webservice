package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){

        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        /*
        * AssertThat
        * - assertj라는 테스트 검증 라이브러리의 검증 메소드
        * - 검증하고 싶은 대상을 메소드 인자로 받습니다.
        * - 메소드 체이닝이 지원되어 isEquaTo와 같이 메소드를 이어서 사용할 수 있습니다.
        *
        *  Junit과 비교하여 assertj의 장점
        * 1. CoreMatchers와 달리 추가적으로 라이브러리가 필요하 지 않습니다.
        * - Junit의 assertThat을 쓰게 되면 is()와 같이 CoreMathcers 라이브러리가 필요합니다.
        * 2. 자동완성이 좀 더 확실하게 지원됩니다.
        * - IDE에서는 CoreMatchers와 같은 matcher 라이브러리의 자동완성 지원이 약합니다.
        * */


    }
}
