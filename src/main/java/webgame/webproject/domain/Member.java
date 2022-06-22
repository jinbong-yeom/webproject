package webgame.webproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "member")//연관관계 주입으로 닉네임에 있는 FK를 중심이 되게 해야함, 매핑이 되어 여기서 값이 변경이 안됨
    private List<Nickname> nicknames = new ArrayList<>();
}
