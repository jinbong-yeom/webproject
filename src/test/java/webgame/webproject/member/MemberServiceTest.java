package webgame.webproject.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import webgame.webproject.AppConfig;
import webgame.webproject.domain.Member;
import webgame.webproject.repository.MemberRepository;
import webgame.webproject.service.MemberService;

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
