package toy.runningtoyprj.web.login;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import toy.runningtoyprj.domain.login.LoginService;
import toy.runningtoyprj.domain.member.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("member")Member member){

        return "/login/login";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute Member member, BindingResult bindingResult,
                        @RequestParam(defaultValue="/")String redirectURL, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/login";
        }
        Member loginMember=loginService.login(member.getLoginId(),member.getPassword());


        if(loginMember==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login";
        }
        HttpSession session=request.getSession();
        session.setAttribute("loginMember",loginMember);
        session.setAttribute("memberId",loginMember.getId());
        return "redirect:"+redirectURL;
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/";
    }
}
