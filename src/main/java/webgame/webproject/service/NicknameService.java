package webgame.webproject.service;

import webgame.webproject.domain.Nickname;

public interface NicknameService {
    void join(Nickname nickname);

    Nickname findNickname(String name);
}
