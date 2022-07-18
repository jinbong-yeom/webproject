package webgame.webproject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@ToString
@Entity
public class Nickname {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Status status;
    
    private String userId = null;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "nickname")
    private List<Auction> auction;
}
