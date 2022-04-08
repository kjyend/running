package toy.runningtoyprj.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class MemberService {

    @Autowired MemberRepository memberRepository;

    public void saveMember(Member member){
        memberRepository.save(member);
    }
    
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //find하다가 예외남
    public Member findOne(String loginId){
        return memberRepository.findOne(loginId);
    }
}
