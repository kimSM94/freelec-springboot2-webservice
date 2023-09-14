package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /*
    *  보통 Mybatis 등에서 Dao라 불리는 DB Layer이며 JPA에서는 Repository라고 부르며 인터페이스로 생성
    *  @Repository를 추가할 필요도 없음, 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치\
    * -> 그래서 도메인 패키지에서 함께 관리
    *
    * */

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
