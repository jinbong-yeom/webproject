package webgame.webproject.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import webgame.webproject.member.MemberRepository;
import webgame.webproject.member.MemoryMemberRepository;

@Getter @Setter
@ToString
public class Order {

    private String memberId;
    private String itemName;

    public Order(String memberId, String itemName) {
        this.memberId = memberId;
        this.itemName = itemName;
    }

}
