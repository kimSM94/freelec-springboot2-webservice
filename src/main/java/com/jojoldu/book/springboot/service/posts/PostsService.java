package com.jojoldu.book.springboot.service.posts;


import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/* RequiredArgsConstructor가 final 선언된 모든 필드를 인자값으로 하는 생성자르 롬복을 대신 생성
* 생성자를 직접 안쓰고 롬복 어노테이션을 사용하는 이유는 해당 클래스의 의존성 관계가 변경될 떄마다 생성자 코드를 계쏙해서 수정해야하는 번거러움을 해소하기 우해*/
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
