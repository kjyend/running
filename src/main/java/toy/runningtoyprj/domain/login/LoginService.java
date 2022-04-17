package toy.runningtoyprj.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){ //로그인 회원이 있는지 검증한다.
        return memberRepository.findByLoginId(loginId).filter(m->m.getPassword().equals(password)).orElse(null);
    }
}
