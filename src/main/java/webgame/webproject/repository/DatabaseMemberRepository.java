package webgame.webproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import webgame.webproject.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DatabaseMemberRepository implements MemberRepository{

    private final EntityManager em;


    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m.name = :name", Member.class)
                .getResultList();
    }
}
