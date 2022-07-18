package webgame.webproject.repository;

import lombok.Getter;
import webgame.webproject.domain.OrderStatus;

@Getter
public class OrderSearch {

    private String memberName;

    private OrderStatus orderStatus;
}
