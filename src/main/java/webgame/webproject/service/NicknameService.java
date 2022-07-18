package webgame.webproject.service;

import webgame.webproject.domain.Nickname;

import java.util.List;

public interface NicknameService {
    Long join(Nickname nickname);

    List<Nickname> findAll();

    Nickname findOne(Long id);


}
