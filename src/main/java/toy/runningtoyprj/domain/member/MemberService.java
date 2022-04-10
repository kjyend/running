package toy.runningtoyprj.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    @Autowired MemberRepository memberRepository;

    public void saveMember(Member member){
        memberRepository.save(member);
    }
    
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }

    public void updateMember(Member member) {
        Member memberFind=memberRepository.findOne(member.getId());
        memberFind.setLoginId(member.getLoginId());
        memberFind.setPassword(member.getPassword());
        memberFind.setName(member.getName());
        memberFind.setDob(member.getDob());
    }
}
