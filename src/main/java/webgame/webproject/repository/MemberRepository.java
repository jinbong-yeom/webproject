package webgame.webproject.repository;

import webgame.webproject.domain.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    Member findOne(String id);

    List<Member> findAll();

    List<Member> findByName(String name);

}
