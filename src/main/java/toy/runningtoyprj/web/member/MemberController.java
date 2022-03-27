package toy.runningtoyprj.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberRepository;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor

@Transactional
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("member")Member member){
        return "login/signup";
    }

    @PostMapping("/signup")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "login/signup";
        }
        memberRepository.save(member);
        return "redirect:/";
    }
    @GetMapping("/modify")
    public String modify(@ModelAttribute("member") Member member){
        return "profile/modify";
    }

    @GetMapping("/profile")
    public String profile(@ModelAttribute("member") Member member){
        return "profile/profile";
    }
}
