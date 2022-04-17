package toy.runningtoyprj.web.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import toy.runningtoyprj.domain.member.Member;



@Controller
@Slf4j
public class HomeController {


    @GetMapping("/")
    public String home(@SessionAttribute(name = "loginMember",required = false)Member loginMember, Model model) {
        if(loginMember==null){//세션을 통해서 로그인 상태인지 아닌지 확인한다. null이면 home화면 출력
            return "home";
        }
        model.addAttribute("member",loginMember);
        return "/running/home";
    }

}
