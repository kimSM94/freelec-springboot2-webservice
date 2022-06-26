package com.jojoldu.book.springboot.web.dto;


import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /* Entity 클래스를 Request/Response 클래스로 사용해서는 안됨
    *  그리고 꼭 Entity 클래스와 Controller에서 쓸 DTo는 분리해서 사용
    * 그리고 View Layer와 db Layer의 역할 분리를 철저하게 하는게 좋음*/
    public Posts toEntity(){
        return Posts.builder().
                title(title)
                .content(content)
                .author(author)
                .build();
    }
}
