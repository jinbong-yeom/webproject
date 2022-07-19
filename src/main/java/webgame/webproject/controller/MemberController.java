package webgame.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webgame.webproject.domain.Member;
import webgame.webproject.service.MemberServiceImpl;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberService;

    @PostMapping("api/account")
    public String create(@RequestBody MemberForm form) {
        System.out.println("form.getUserId() = " + form.getUserId());
        Member member = new Member();
        member.setUserId(form.getUserId());
        member.setPassword(form.getUserPassword());
        memberService.join(member);

        return "redirect:/";
    }
}
