package webgame.webproject.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private String id;
    private String name;
    private String password;
    private int money;

    public Member(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = 1000000;
    }

    public void Calculator(int price) {
        this.money -= price;
    }

}
