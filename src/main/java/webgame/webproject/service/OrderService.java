package webgame.webproject.service;

import webgame.webproject.domain.Order;
import webgame.webproject.repository.OrderSearch;

import java.util.List;

public interface OrderService {


    Long createOrder(Long memberId, Long itemId);

    void refund(Long orderId);

    List<Order> findOrders(OrderSearch orderSearch);


}
