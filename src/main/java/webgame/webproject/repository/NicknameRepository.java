package webgame.webproject.repository;

import webgame.webproject.domain.Member;
import webgame.webproject.domain.Nickname;

import java.util.List;

public interface NicknameRepository {
    void save(Nickname nickname);

    Nickname findOne(Long id);

    List<Nickname> findAll();

    List<Nickname> findByName(String name);

}
