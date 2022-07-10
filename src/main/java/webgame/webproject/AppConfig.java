package webgame.webproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import webgame.webproject.repository.MemberRepository;
import webgame.webproject.service.MemberService;
import webgame.webproject.service.MemberServiceImpl;
import webgame.webproject.repository.MemoryMemberRepository;
import webgame.webproject.repository.MemoryNicknameRepository;
import webgame.webproject.repository.NicknameRepository;
import webgame.webproject.service.NicknameService;
import webgame.webproject.service.NicknameServiceImpl;
import webgame.webproject.service.OrderService;
import webgame.webproject.service.OrderServiceImpl;

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
