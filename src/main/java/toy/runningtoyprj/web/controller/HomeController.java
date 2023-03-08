package toy.runningtoyprj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import toy.runningtoyprj.domain.entity.Member;
import toy.runningtoyprj.dto.LoginDto;
import toy.runningtoyprj.web.argumentresolver.Login;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@Login LoginDto memberDto, Model model){
        model.addAttribute("member",memberDto);
        if(memberDto==null){
            return "home";
        }
        return "/running/home";
    }

}
