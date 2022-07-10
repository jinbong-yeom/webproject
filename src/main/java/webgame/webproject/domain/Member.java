package webgame.webproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private long id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column
    private int money;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public void Calculator(int price) {
        this.money -= price;
    }

}
