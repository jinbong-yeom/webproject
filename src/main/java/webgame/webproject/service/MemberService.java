package webgame.webproject.service;


import webgame.webproject.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(String memberId);
}
