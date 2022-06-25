package webgame.webproject.nickname;

public interface NicknameService {
    void join(Nickname nickname);

    Nickname findNickname(String name);
}
