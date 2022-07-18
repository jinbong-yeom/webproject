package webgame.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import webgame.webproject.domain.*;
import webgame.webproject.repository.MemberRepository;
import webgame.webproject.repository.NicknameRepository;
import webgame.webproject.repository.OrderRepository;
import webgame.webproject.repository.OrderSearch;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor //생성자
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final NicknameRepository nicknameRepository;

    @Override
    public Long createOrder(Long memberId, Long nicknameId) {
        Member member = memberRepository.findOne(memberId);
        Nickname nickname = nicknameRepository.findOne(nicknameId);

        OrderNickname orderNickname = OrderNickname.createOrder(nickname);

        Order order = Order.createOrder(member, orderNickname);

        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public void refund(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.refund();
    }

    @Override
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
}
