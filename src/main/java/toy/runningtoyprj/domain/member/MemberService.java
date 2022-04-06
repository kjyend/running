package toy.runningtoyprj.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MemberService {
    @Autowired  MemberRepository memberRepository;

    public void saveMember(Member member){
        memberRepository.save(member);
    }

    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }

    public Member findLogin(String loginId){
        return memberRepository.findByLoginId(loginId).filter(m->m.getLoginId().equals(loginId)).orElse(null);
    }
}
