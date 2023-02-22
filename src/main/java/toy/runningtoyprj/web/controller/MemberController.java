package toy.runningtoyprj.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import toy.runningtoyprj.dto.UpdateDto;
import toy.runningtoyprj.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

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

