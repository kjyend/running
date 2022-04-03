package toy.runningtoyprj.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberController {

    @Autowired MemberService memberService;

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("member")Member member){
        return "login/signup";
    }

    @PostMapping("/signup")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "login/signup";
        }
        memberService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping("/modify")
    public String updateForm(@ModelAttribute("member") Member member){
        return "profile/modify";
    }

    @PostMapping("/modify")
    public String update(@ModelAttribute("member") Member member){
        memberService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(@ModelAttribute("member") Member member){//회원 조회
        memberService.findMember(member.getLoginId());
        return "profile/profile";
    }
}
