package webgame.webproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nicknames")
@Getter @Setter
public class Nickname {

    @Id @GeneratedValue
    @Column(name = "nickname_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "nickname")
    private List<NicknameItem> nicknameItems = new ArrayList<>();


}
