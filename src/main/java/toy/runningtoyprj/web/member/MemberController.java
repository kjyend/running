package toy.runningtoyprj.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired MemberService memberService;

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("member")Member member){
        return "login/signup";//회원 가입 form
    }

    @PostMapping("/signup")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){//회원가입에 오류가 이있다면 실행된다.
            return "login/signup";
        }
        memberService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping( "/modify")
    public String updateForm(@ModelAttribute("member") Member member){
        return "profile/modify"; //회원 수정 form
    }

    @PostMapping("/modify")
    public String update(@ModelAttribute("member") Member member,HttpServletRequest request){// 회원 수정
        HttpSession session = request.getSession(); //세션값을 얻는다.
        memberService.updateMember((Long) session.getAttribute("memberId"),member);//세션을 통해서 회원수정한다.
        return "redirect:/";
    }

}

