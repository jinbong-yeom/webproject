package webgame.webproject.repository;

import org.springframework.stereotype.Repository;
import webgame.webproject.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findOne(Long id) {
        return store.get(id);
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public List<Member> findByName(String name) {
        return null;
    }

}
