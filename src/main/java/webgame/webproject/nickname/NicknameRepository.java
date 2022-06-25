package webgame.webproject.nickname;

public interface NicknameRepository {
    void save(Nickname nickname);

    Nickname findByName(String name);
}
