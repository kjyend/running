package toy.runningtoyprj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.runningtoyprj.domain.entity.Member;
import toy.runningtoyprj.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){ //로그인 회원이 있는지 검증한다.
        return memberRepository.findByLoginId(loginId).filter(m->m.getPassword().equals(password)).orElse(null);
    }
}
