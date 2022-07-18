package webgame.webproject.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자를 protected로 보호해 다른 곳에서 선언 x
public class OrderNickname {

    @Id @GeneratedValue
    @Column(name = "order_nickname_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "nickname_id")
    private Nickname nickname;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;

    public static OrderNickname createOrder(Nickname nickname) {
        OrderNickname orderNickname = new OrderNickname();
        orderNickname.setNickname(nickname);
        orderNickname.setOrderPrice(nickname.getPrice());

        return orderNickname;
    }

    //비즈니스
    //환불할경우
    public void refund() {
        getNickname().setStatus(Status.AVAILABLE);
    }

    //조회
    public int getTotalPrice() {
        return getOrderPrice();
    }
}
