package webgame.webproject.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @PostMapping("/api/account")
    public void hello_post(@RequestBody Login login) {
        System.out.println(login.getLoginId()+"아이디   "+ login.getLoginPw());

    }

    @Getter @Setter
    @ToString
    static class Login {
        private String loginId;
        private String loginPw;
    }
}

