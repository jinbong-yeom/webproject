package webgame.webproject.repository;

import org.springframework.stereotype.Repository;
import webgame.webproject.domain.Nickname;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
@Repository
public class MemoryNicknameRepository implements NicknameRepository {

    private static Map<String, Nickname> store = new HashMap<>();

    @Override
    public void save(Nickname nickname) {
        store.put(nickname.getName(), nickname);
    }

    @Override
    public Nickname findOne(Long id) {
        return store.get(id);
    }

    @Override
    public List<Nickname> findAll() {
        return null;
    }

    @Override
    public List<Nickname> findByName(String name) {
        return null;
    }
}
