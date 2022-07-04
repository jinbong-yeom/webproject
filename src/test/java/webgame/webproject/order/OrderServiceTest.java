package webgame.webproject.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webgame.webproject.AppConfig;
import webgame.webproject.member.Member;
import webgame.webproject.member.MemberService;
import webgame.webproject.member.MemberServiceImpl;
import webgame.webproject.nickname.Nickname;
import webgame.webproject.nickname.NicknameService;
import webgame.webproject.nickname.NicknameServiceImpl;
import webgame.webproject.nickname.Status;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {


    MemberService memberService;
    NicknameService nicknameService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        nicknameService = appConfig.nicknameService();
        orderService = appConfig.orderService();
    }

    @Test
    public void 일반적인_구매() throws Exception {
        //given
        String memberId = "member";
        Member member = new Member(memberId, "lee", "1234");
        memberService.join(member);

        Nickname nickname = new Nickname(1L, "사자", 100, Status.AVAILABLE);
        nicknameService.join(nickname);
        //when
        Order order = orderService.createOrder(memberId, "사자");

        //then
        assertThat(nickname.getUserId()).isEqualTo(memberId);
        assertThat(nickname.getStatus()).isEqualTo(Status.USED);
    }

    @Test
    public void 사용중인_별명을_살경우() throws Exception {
        //given
        String memberA = "memberA";
        String memberB = "memberB";
        Member member1 = new Member(memberA, "lee", "1234");
        Member member2 = new Member(memberB, "park", "1234");
        memberService.join(member1);
        memberService.join(member2);

        Nickname nickname = new Nickname(1L, "사자", 100, Status.AVAILABLE);
        nicknameService.join(nickname);
        Order order1 = orderService.createOrder(memberA, "사자");
        //when
        Order order2 = orderService.createOrder(memberB, "사자");

        //then
        assertThat(nickname.getUserId()).isEqualTo(memberA);
    }
    
    @Test
    public void 돈이_부족한_경우() throws Exception {
        //given
        String memberA = "memberA";
        Member member1 = new Member(memberA, "lee", "1234");
        memberService.join(member1);

        Nickname nickname = new Nickname(1L, "사자", 2000000000, Status.AVAILABLE);
        nicknameService.join(nickname);
        //when
        Order order = orderService.createOrder(memberA, "사자");
        //then
        assertThat(nickname.getUserId()).isNull();
    }
    
    @Test
    public void 멤버나_닉네임을_잘못적은_경우() throws Exception {
        //given
        String memberA = "memberA";
        Member member1 = new Member(memberA, "lee", "1234");
        memberService.join(member1);

        Nickname nickname = new Nickname(1L, "사자", 2000000000, Status.AVAILABLE);
        nicknameService.join(nickname);
        //when
        Order order1 = orderService.createOrder("이름 잘못적음", "사자");
        Order order2 = orderService.createOrder(memberA, "호랑이");
        //then
        assertThat(nickname.getUserId()).isNull();
    }
}
