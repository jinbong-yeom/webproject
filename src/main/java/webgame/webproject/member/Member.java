package webgame.webproject.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column()
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
