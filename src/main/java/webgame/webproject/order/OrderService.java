package webgame.webproject.order;

public interface OrderService {
    Order createOrder(String memberId, String itemName);

    void showAllList();


}
