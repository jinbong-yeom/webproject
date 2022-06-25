package webgame.webproject.order;

import webgame.webproject.member.Member;
import webgame.webproject.member.MemberRepository;
import webgame.webproject.member.MemoryMemberRepository;
import webgame.webproject.nickname.MemoryNicknameRepository;
import webgame.webproject.nickname.Nickname;
import webgame.webproject.nickname.NicknameRepository;
import webgame.webproject.nickname.Status;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final NicknameRepository nicknameRepository = new MemoryNicknameRepository();

    @Override
    public Order createOrder(String memberId, String itemName) {
        try {
            Member member = memberRepository.findById(memberId);
            Nickname nickname = nicknameRepository.findByName(itemName);


            Status status = nickname.getStatus();

            switch (status){
                case USED:
                    System.out.println("This Nickname is used in " + nickname.getUserId());
                    break;

                case AVAILABLE:
                    if (member.getMoney() < nickname.getPrice()){
                        System.out.println("돈이 부족합니다.");
                        break;
                    }
                    else {
                        member.Calculator(nickname.getPrice());
                        System.out.println("남은 돈은 "+member.getMoney()+" 입니다.");
                        nickname.setUserId(member.getId());
                        nickname.setStatus(Status.USED);
                        return new Order(memberId, itemName);
                    }
            }
            return null;

        } catch (NullPointerException e) {
            System.out.println("잘못 입력하셨습니다.");
            return null;
        }

    }

    @Override
    public void showAllList() {
        nicknameRepository.toString();
    }
}
