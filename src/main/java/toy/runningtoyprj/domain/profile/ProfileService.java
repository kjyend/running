package toy.runningtoyprj.domain.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.runningtoyprj.domain.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final MemberRepository memberRepository;


}
