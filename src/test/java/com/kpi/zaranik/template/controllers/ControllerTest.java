package com.kpi.zaranik.template.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class ControllerTest {

    @Test
    void testExchangeAPI() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String request = """
                    {
                      "userId": 1000,
                      "title": "title",
                      "body": "body",
                      "id": 101
                    }
                """;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(request, httpHeaders);
        String s = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", entity, String.class);
        System.out.println(s);
    }

    @Test
    void testExchangeAPIDto() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        PostDto post = new PostDto(1, 1, "bogan", "zaranik");
        PostDto s = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", post, PostDto.class);
        System.out.println(s);
    }

}

@ToString
@Getter
@Setter
@AllArgsConstructor
class User{
    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class PostDto{
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
