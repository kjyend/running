package toy.runningtoyprj.web.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberRepository;

@Controller
@Transactional
@RequiredArgsConstructor
public class ProfileController {

    private final MemberRepository memberRepository;

    @GetMapping("/modify")
    public String modify(@ModelAttribute("member") Member member){
        return "profile/modify";
    }

    @GetMapping("/profile")
    public String profile(@ModelAttribute("member") Member member){
        return "profile/profile";
    }


}
