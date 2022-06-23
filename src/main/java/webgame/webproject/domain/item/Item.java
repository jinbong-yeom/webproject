package webgame.webproject.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter

public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private long id;

    private String name;
    private int price;


}
