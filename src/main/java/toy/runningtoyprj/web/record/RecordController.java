package toy.runningtoyprj.web.record;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberService;
import toy.runningtoyprj.domain.record.Record;
import toy.runningtoyprj.domain.record.RecordRepository;
import toy.runningtoyprj.domain.record.RecordService;

import java.util.Optional;

@Slf4j
@Controller
@Transactional
public class RecordController {

    @Autowired
    RecordService recordService;
    @Autowired
    MemberService memberService;

    @GetMapping("/record")
    public String community(@SessionAttribute(name = "loginMember",required = false) Member loginMember, Model model){
        if(loginMember==null){
            return "home";
        }
        model.addAttribute("member",loginMember);
        return "record/record";
    }

    @PostMapping("/record")
    public String checkRecord(@ModelAttribute("record")Record record){
        return "redirect:/record";
    }

    @GetMapping("/check")
    public String check(@ModelAttribute("record") Record record){
        return "record/check";
    }

    @PostMapping("/check")
    public String saveCheck(@ModelAttribute("record")Record record){
        recordService.saveRecord(record);
        return "redirect:/check";
    }

}
