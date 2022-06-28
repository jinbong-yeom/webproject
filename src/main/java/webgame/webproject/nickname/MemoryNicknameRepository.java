package webgame.webproject.nickname;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryNicknameRepository implements NicknameRepository {

    private static Map<String, Nickname> store = new HashMap<>();

    @Override
    public void save(Nickname nickname) {
        store.put(nickname.getName(), nickname);
    }

    @Override
    public Nickname findByName(String name) {
        return store.get(name);
    }
}
