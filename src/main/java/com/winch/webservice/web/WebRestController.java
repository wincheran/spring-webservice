package com.winch.webservice.web;

import com.winch.webservice.domain.posts.PostsRepository;
import com.winch.webservice.dto.posts.PostsSaveRequestDto;
import com.winch.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController는 @ResponseBody를 모든 메소드에서 적용해준다.
@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

// 3강에서 주석처리된 코드.
//    @PostMapping("/posts")
//    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
//        postsRepository.save(dto.toEntity());
//    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
