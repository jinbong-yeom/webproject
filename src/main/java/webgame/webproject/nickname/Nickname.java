package webgame.webproject.nickname;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@ToString
@Entity
@NoArgsConstructor
public class Nickname {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Status status;


    private String userId = null;

    public Nickname(Long id, String name, int price, Status status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }
}
