package com.jojoldu.book.springboot.service.posts;


import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/* RequiredArgsConstructor가 final 선언된 모든 필드를 인자값으로 하는 생성자르 롬복을 대신 생성
 * 생성자를 직접 안쓰고 롬복 어노테이션을 사용하는 이유는 해당 클래스의 의존성 관계가 변경될 떄마다 생성자 코드를 계쏙해서 수정해야하는 번거러움을 해소하기 dnl해*/
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다.id >>" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;

    }
    /*
    * 현재 Update 메소드에 DB 쿼리 날리는 부분이 없는데 이게 JPA 영속성 컨텍스트 때문 가능
    * 영속성 컨텍스트란 엔티티를 영구 저장하는 환경이며 일종의 논리적 개념
    * */

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
