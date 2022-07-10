package webgame.webproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import webgame.webproject.domain.Member;
import webgame.webproject.service.MemberService;
import webgame.webproject.domain.Nickname;
import webgame.webproject.service.NicknameService;
import webgame.webproject.domain.Status;
import webgame.webproject.domain.Order;
import webgame.webproject.service.OrderService;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = AppConfig.memberService();
//        OrderService orderService = AppConfig.orderService();
//        NicknameService nicknameService = AppConfig.nicknameService();
        //스프링 컨테이너
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //getBean으로 스프링 빈을 찾음
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        NicknameService nicknameService = ac.getBean("nicknameService", NicknameService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Nickname nickname1 = new Nickname(1L, "사자", 1000, Status.AVAILABLE);
        Nickname nickname2 = new Nickname(2L, "호랑이", 100000000, Status.AVAILABLE);
        nicknameService.join(nickname1);
        nicknameService.join(nickname2);


        String memberId = "member";
        Member member = new Member(memberId, "lee", "1234");
        memberService.join(member);

        Order order1 = orderService.createOrder(memberId, "사자");
        Order order2 = orderService.createOrder(memberId, "사자");
        Order order3 = orderService.createOrder(memberId, "dd");
        Order order4 = orderService.createOrder(memberId, "호랑이");

        System.out.println("nickname1 = " + nickname1);
        System.out.println("nickname2 = " + nickname2);

    }

}
