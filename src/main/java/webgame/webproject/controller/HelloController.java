package webgame.webproject.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("api/account")
    @ResponseBody
    public String helloApi() {
//        Hello hello = new Hello();
//        hello.setMemberName("홀길동");
//        hello.setMid(3);
//        return hello;
        return "sss";
    }

    @PostMapping("api/account")
    public String hello_post(@RequestBody Login login) {
        return login.getLoginId()+"아이디"+ login.getLoginPw();
    }

    @Getter @Setter
    static class Hello {
        private String memberName;
        private int mid;
    }

    @Getter @Setter
    @ToString
    static class Login {
        private String loginId;
        private String loginPw;
    }
}

