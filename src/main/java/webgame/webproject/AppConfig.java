package webgame.webproject;

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

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public NicknameService nicknameService() {
        return new NicknameServiceImpl(nicknameRepository());
    }

    private NicknameRepository nicknameRepository() {
        return new MemoryNicknameRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), nicknameRepository());
    }
}
