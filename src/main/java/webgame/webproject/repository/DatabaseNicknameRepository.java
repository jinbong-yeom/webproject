package webgame.webproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webgame.webproject.domain.Nickname;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DatabaseNicknameRepository implements NicknameRepository {

    private final EntityManager em;

    @Override
    @Transactional
    public void save(Nickname nickname) {
        em.persist(nickname);
    }

    @Override
    public Nickname findOne(Long id) {
        return em.find(Nickname.class, id);
    }

    @Override
    public List<Nickname> findAll() {
        return em.createQuery("select n from Nickname n", Nickname.class)
                .getResultList();
    }

    @Override
    public List<Nickname> findByName(String name) {
        return em.createQuery("select n from Nickname n where n.name = :name", Nickname.class)
                .getResultList();
    }
}
