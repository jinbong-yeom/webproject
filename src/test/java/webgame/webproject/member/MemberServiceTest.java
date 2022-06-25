package webgame.webproject.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member("1234","mamberA", "12345");

        //when
        memberService.join(member);
        Member findMember = memberService.findMember("1234");

        //then
        assertThat(member).isEqualTo(findMember);
    }
}
