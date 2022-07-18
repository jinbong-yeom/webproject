package webgame.webproject.domain;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderNickname> orderNicknames = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public void addOrderNickname(OrderNickname orderNickname) {
        orderNicknames.add(orderNickname);
        orderNickname.setOrder(this);
    }

    public static Order createOrder(Member member, OrderNickname... orderNicknames) {
        Order order = new Order();
        order.setMember(member);
        for (OrderNickname orderNickname : orderNicknames) {
            order.addOrderNickname(orderNickname);
        }
        order.setOrderStatus(OrderStatus.REFUNDABLE);
        return order;
    }

    public void refund() {
        if(orderStatus == OrderStatus.NON_REFUNDABLE) {
            throw new IllegalStateException("환불 불가능한 상품입니다");
        }
        for (OrderNickname orderNickname : orderNicknames) {
            orderNickname.refund();
        }
    }
}
