package webgame.webproject.domain;

import lombok.Getter;
import lombok.Setter;
import webgame.webproject.domain.item.Item;

import javax.persistence.*;

@Entity
@Getter @Setter
public class NicknameItem {

    @Id @GeneratedValue
    @Column(name = "nickname_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "nickname_id")
    private Nickname nickname;

    private int orderPrice; //주문 가격

}
