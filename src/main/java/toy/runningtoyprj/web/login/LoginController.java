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
        return "/login/login";//로그인 폼
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute Member member, BindingResult bindingResult,
                        @RequestParam(defaultValue="/")String redirectURL, HttpServletRequest request){//세션값을 통해서 로그인 실행
        if(bindingResult.hasErrors()){//오류가 있으면 다시 로그인 화면으로 간다.
            return "login/login";
        }
        Member loginMember=loginService.login(member.getLoginId(),member.getPassword()); // 세션값을 통해서 로그인했을때 db에 정보가 있는지 확인


        if(loginMember==null){ //db에 정보가 없는경우
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login";
        }
        HttpSession session=request.getSession();//db에 있다면 세션값을 저장한다.
        session.setAttribute("loginMember",loginMember);//로그인 값을 세션 loginMember값에 저장한다.
        session.setAttribute("memberId",loginMember.getId());// member.id값을 세션 memberId에 저장한다.

        return "redirect:"+redirectURL;
    }
    @PostMapping("/logout")//로그아웃
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession(false);//세션값을 false한다.
        if(session!=null){ //session값이 null이 안되었다면 실행한다.
            session.invalidate();
        }
        return "redirect:/";
    }
}
