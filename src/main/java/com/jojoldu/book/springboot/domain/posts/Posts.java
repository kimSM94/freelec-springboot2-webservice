package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Getter
@NoArgsConstructor
@Entity
public class Posts {

    /*
    * Entity는 JPA의 어노테이션이며, @Getter, @NoArgsConstrucotr는 롬복의 어노테이션
    * 롬복은 코드를 단수화시켜 주지면 필수 어노테이션은 아님
    * 그래서 주요 어노테이션 @Entity를 클래스에 가깝게 두고 롬복 어노테이션을 위로
    * 이렇게 하면 이후에 코틀린 등의 새 언어 전ㄹ환으로 롬복이 더이상 필요 없을 경우 쉽게 삭제 가능
    * Posts 클래스는 보통 Entity 클래스라고도 함
    *
    * @Entity
    * - 테이블과 링크될 클래스임을 나타냅니다.
    * - 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
    * EX) SalesManager.java -> slaes_manager table
    *
    * @ Id
    * - 해당 테이블의 PK 필드를 나타냅니다.
    *
    * @GeneratedValue
    * - PK의 생성 규칙을 나타냅니다.
    * - 스프링 부트 2.0 에서는 GenerationType.IDENTIIY 옵션을 추가해야만 auto_increment가 됨
    *
    * @Column
    * - 테이블의 칼럼을 나타내며 굳이 선언하지 않더라고 해당 클래스의 필드는 모두 칼럼
    * - 사용하는 이유는, 기본값 외에 추가로 변경이 필요할때
    * 문자열의 결우 Varchar(255)가 기본값
    *
    *  참고
    * - 웬만하면 Entity의 PK는 Long 타입의 Auto_incrementㄹㄹ 추천
    * - 주민등록번호와 같이 비즈니스상 유니크 키나, 여러키를 조합한 복합키로 PK를 잡을 경우 난간함 상황 종종 발생
    * 1) FK를 맺을 때 다른 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나 더 둬야 하는 상황이 발생
    * 2) 인덱스에 좋은 영향을 끼치지 못합니다.
    * 3) 유니크한 조건이 변경될 경우 PK 전체를 수정해야 하는 일이 밠ㅇ
    * - 주민등록번호, 복합키 등은 유니크 키로 별도로 추가하시는것을 추천   *
    *
    * @ NoArgsConstructor
    * - 기본 생성자 자동 추가
    * - public Posts(){}와 같은 효과
    *
    * @Getter
    * - 클래스 내 모든 필드의 Getter 메소드를 자동 생성
    *
    * @Builder
    * - 해당 클래스의 빌더 패턴 클래스를 생성
    * - 생성자 상단 선언 시 생성자에 포함된 필드만 빌더에 포함함\
    *
    * - Setter 메소드가 없는데, 언제 어디서 변해야하는지 코드상으로 명확하게 구분할 수가 없어, 차후 기능 변경 시 복잡
    *   그래서 절대 생성 X   * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;

    }
}
