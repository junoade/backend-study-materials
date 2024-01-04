package com.example.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    public String test() {
        log.info("Test method called");
        return "Hello";
    }
}
