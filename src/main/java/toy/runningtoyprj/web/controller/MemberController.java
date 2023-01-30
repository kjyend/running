package toy.runningtoyprj.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.runningtoyprj.domain.entity.Member;
import toy.runningtoyprj.dto.MemberDto;
import toy.runningtoyprj.dto.UpdateDto;
import toy.runningtoyprj.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signupForm(MemberDto member, Model model){
        model.addAttribute("member", member);
        return "login/signup";//회원 가입 form
    }

    @PostMapping("/signup")
    public String save(@Valid MemberDto member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){//회원가입에 오류가 이있다면 실행된다.
            return "login/signup";
        }
        memberService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping( "/modify")
    public String updateForm(UpdateDto member,Model model){
        model.addAttribute("member",member);
        return "profile/modify"; //회원 수정 form
    }

    @PostMapping("/modify")
    public String update(UpdateDto member,HttpServletRequest request){// 회원 수정
        HttpSession session = request.getSession(); //세션값을 얻는다.
        memberService.updateMember((Long) session.getAttribute("memberId"),member);//세션을 통해서 회원수정한다.
        return "redirect:/";
    }

}

