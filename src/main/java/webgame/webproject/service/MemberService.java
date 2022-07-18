package webgame.webproject.service;


import webgame.webproject.domain.Member;

import java.util.List;

public interface MemberService {

    Long join(Member member);

    List<Member> findMembers();

    Member findMember(Long memberId);

}
