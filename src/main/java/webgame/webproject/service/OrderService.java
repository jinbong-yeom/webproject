package webgame.webproject.service;

import webgame.webproject.domain.Order;

public interface OrderService {
    Order createOrder(String memberId, String itemName);

    void showAllList();


}
