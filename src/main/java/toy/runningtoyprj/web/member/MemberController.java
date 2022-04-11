package toy.runningtoyprj.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    @Autowired MemberService memberService;

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("member")Member member){
        log.info("=={}",member.getId());
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

    @GetMapping( "/modify")
    public String updateForm(@ModelAttribute("member") Member member,HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("=={}",member.getId());
        log.info("=={}==",session.getAttribute("loginMember").toString());
        return "profile/modify";
    }

    @PostMapping("/modify")
    public String update(@ModelAttribute("member") Member member){
        memberService.updateMember(member);//세션값,맴버값을 쏘고 세션값을 확인하고 멤버값으로 변경
        return "redirect:/";
    }

}

