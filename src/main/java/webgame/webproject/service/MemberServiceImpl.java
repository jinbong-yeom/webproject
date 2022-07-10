package webgame.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webgame.webproject.domain.Member;
import webgame.webproject.repository.MemberRepository;

//@Component
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

//    @Autowired 생략가능
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }


    @Override
    public Member findMember(String memberId) {
        return memberRepository.findById(memberId);
    }
}
