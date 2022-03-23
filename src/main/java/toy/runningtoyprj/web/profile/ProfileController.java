package toy.runningtoyprj.web.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import toy.runningtoyprj.domain.member.MemberRepository;

@RestController
@Transactional
@RequiredArgsConstructor
public class ProfileController {
    private final MemberRepository memberRepository;


}
