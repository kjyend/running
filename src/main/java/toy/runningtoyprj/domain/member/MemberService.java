package toy.runningtoyprj.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MemberService {
    @Autowired  MemberRepository memberRepository;

    public void saveMember(Member member){
        memberRepository.save(member);
    }

    public Optional<Member> findMember(String loginId){//회원 조회
        return memberRepository.MemberInformation(loginId);
    }
}
