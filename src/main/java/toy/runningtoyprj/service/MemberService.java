package toy.runningtoyprj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.runningtoyprj.domain.entity.Member;
import toy.runningtoyprj.dto.MemberDto;
import toy.runningtoyprj.dto.UpdateDto;
import toy.runningtoyprj.repository.MemberRepository;



@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberDto memberDto){// 회원 가입 목적
        Member member = memberDto.toMemberEntity();
        memberRepository.save(member);
    }

    public void updateMember(Long id, UpdateDto member) {// 회원 수정 목적
        Member memberFind=memberRepository.findOne(id);

        memberFind.builder()
                .loginId(member.getLoginId())
                .password(member.getPassword())
                .name(member.getName())
                .dob(member.getDob())
                .build();
    }
}
