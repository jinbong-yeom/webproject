package webgame.webproject.nickname;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Nickname {
    private Long id;

    private String name;

    private int price;

    private Status status;

    private String userId;

    public Nickname(Long id, String name, int price, Status status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }
}
