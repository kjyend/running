package toy.runningtoyprj.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import toy.runningtoyprj.dto.LoginDto;
import toy.runningtoyprj.dto.MemberDto;
import toy.runningtoyprj.service.LoginService;
import toy.runningtoyprj.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

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

    @GetMapping("/login")
    public String loginForm(LoginDto memberDto, Model model){
        model.addAttribute("memberDto",memberDto);
        return "/login/login";//로그인 폼
    }

    @PostMapping("/login")
    public String login(@Valid LoginDto memberDto, BindingResult bindingResult,
                        //@RequestParam(defaultValue="/")String redirectURL,
                        HttpServletRequest request){//세션값을 통해서 로그인 실행
        if(bindingResult.hasErrors()){//오류가 있으면 다시 로그인 화면으로 간다.
            return "login/login";
        }
        LoginDto loginMember=loginService.login(memberDto.getLoginId(),memberDto.getPassword()); // 세션값을 통해서 로그인했을때 db에 정보가 있는지 확인

        log.info(">>>{}", loginMember);
        if(loginMember==null){ //db에 정보가 없는경우
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "redirect:/login";
        }

        log.info(">>>{}", loginMember);

        HttpSession session=request.getSession();//db에 있다면 세션값을 저장한다.
        session.setAttribute("loginMember",loginMember.getClass());//로그인 값을 세션 loginMember값에 저장한다.
        session.setAttribute("memberId",loginMember.getId());// member.id값을 세션 memberId에 저장한다.

        log.info(">>>{}", loginMember);

        return "redirect:/";//+redirectURL;
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
