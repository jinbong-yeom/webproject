package webgame.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webgame.webproject.domain.*;
import webgame.webproject.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor //생성자
public class OrderServiceImpl implements OrderService {

    private final DatabaseOrderRepository orderRepository;
    private final DatabaseMemberRepository memberRepository;
    private final DatabaseNicknameRepository nicknameRepository;

    @Override
    @Transactional
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
