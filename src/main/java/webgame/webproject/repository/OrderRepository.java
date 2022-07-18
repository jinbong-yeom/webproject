package webgame.webproject.repository;

import webgame.webproject.domain.Order;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    Order findOne(Long id);

    List<Order> findAll(OrderSearch orderSearch);

}
