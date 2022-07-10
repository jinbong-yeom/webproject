package webgame.webproject.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @PostMapping("/api/account")
    public String hello_post(@RequestBody Login login) {
        System.out.println(login.getLoginId()+"아이디   "+ login.getLoginPw());
        return "ok";
    }

    @Getter @Setter
    @ToString
    static class Login {
        private String loginId;
        private String loginPw;
    }
}

