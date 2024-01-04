package com.example.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    /**
     * CORS 작동을 확인하기 위해 다른 출처에서 호출할 엔드포인트 정의
     * @return
     */
    @PostMapping("/test")
    @ResponseBody
    // @CrossOrigin("http://localhost:8080") // localhost 출처(Origin)에 대한 교차 출처(Cross-Origin) 요청을 허용;
    public String test() {
        log.info("Test method called");
        return "Hello";
    }
}
