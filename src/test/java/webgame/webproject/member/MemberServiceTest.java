package webgame.webproject.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import webgame.webproject.AppConfig;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberServiceTest {

    MemberService memberService;
    MemberRepository memberRepository;


    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        memberRepository = appConfig.memberRepository();
    }

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member("1234","memberA", "12345");

        //when
        memberService.join(member);
        Member findMember = memberService.findMember("1234");

        //then
        assertThat(member).isEqualTo(findMember);
    }
}
