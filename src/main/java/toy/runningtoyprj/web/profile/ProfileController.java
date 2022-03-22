package toy.runningtoyprj.web.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import toy.runningtoyprj.domain.member.MemberRepository;

@Controller
@Transactional
@RequiredArgsConstructor
public class ProfileController {
    private final MemberRepository memberRepository;


}
