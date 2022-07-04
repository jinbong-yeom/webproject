package webgame.webproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import webgame.webproject.member.MemberRepository;
import webgame.webproject.member.MemberService;
import webgame.webproject.member.MemberServiceImpl;
import webgame.webproject.member.MemoryMemberRepository;
import webgame.webproject.nickname.MemoryNicknameRepository;
import webgame.webproject.nickname.NicknameRepository;
import webgame.webproject.nickname.NicknameService;
import webgame.webproject.nickname.NicknameServiceImpl;
import webgame.webproject.order.OrderService;
import webgame.webproject.order.OrderServiceImpl;

//스프링 컨테이너가 어노테이션 붙은 설정 정보를 사용
@Configuration
public class AppConfig {
    //어노테이션 붙은 모든 메서드를 호출 하고 스프링 컨테이너에 등록
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public NicknameService nicknameService() {
        return new NicknameServiceImpl(nicknameRepository());
    }

    @Bean
    public NicknameRepository nicknameRepository() {
        return new MemoryNicknameRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), nicknameRepository());
    }
}
