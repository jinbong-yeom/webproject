package webgame.webproject.repository;

import webgame.webproject.domain.Nickname;

public interface NicknameRepository {
    void save(Nickname nickname);

    Nickname findByName(String name);
}
