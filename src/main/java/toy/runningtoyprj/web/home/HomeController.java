package toy.runningtoyprj.web.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import toy.runningtoyprj.domain.member.Member;



@Controller
@Transactional
@Slf4j
public class HomeController {


    @GetMapping("/")
    public String home(@SessionAttribute(name = "loginMember",required = false)Member loginMember, Model model) {
        if(loginMember==null){
            return "home";
        }
        model.addAttribute("member",loginMember);
        return "/running/home";
    }

}
