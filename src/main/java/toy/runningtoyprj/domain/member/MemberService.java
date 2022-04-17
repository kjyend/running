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

    public void saveMember(Member member){// 회원 가입 목적
        memberRepository.save(member);
    }
    

    public void updateMember(Long id,Member member) {// 회원 수정 목적
        Member memberFind=memberRepository.findOne(id);
        memberFind.setLoginId(member.getLoginId());
        memberFind.setPassword(member.getPassword());
        memberFind.setName(member.getName());
        memberFind.setDob(member.getDob());
    }
}
