package com.jojoldu.book.springboot.web.domain.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {


    /*
    * After
    * - Junit에서 단테가 끝날 때마다 수행되는 메소드를 지정
    * - 보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
    * - 여러 테스트가 통시에 수행되면 테스트용 DB인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행시 실패 할 수 ㅣㅇ씅ㅁ
    *
    * postsRepository.save
    * 테이블에 posts에 insert/update 쿼리를 실행
    * id 값이 있따면 update, 없으면 insert
    *
    * findAll
    * - 테이블 posts에 있는 모든 데이터를 조회해오는 메소드
    *
    * @SpringBootTest를 사용할 경우 H2 DB를 자동으로 실행해줌
    * */

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmailc.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
