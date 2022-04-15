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
import toy.runningtoyprj.domain.record.Record;
import toy.runningtoyprj.domain.record.RecordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@Transactional
public class RecordController {

    @Autowired
    RecordService recordService;

    @GetMapping("/check")
    public String check(@ModelAttribute("record") Record record){
        return "record/check";
    }

    @PostMapping("/check")
    public String saveCheck(@ModelAttribute("record")Record record, HttpServletRequest request){
        HttpSession session = request.getSession();
        recordService.saveRecord(record, (Member) session.getAttribute("loginMember"));
        log.info("member=={}",session.getAttribute("loginMember"));
        return "redirect:/check";
    }

    @GetMapping("/record")
    public String community(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Record> all = recordService.findAll();
        for (Record record : all) {
            if(record.getMember().getId().equals(session.getAttribute("memberId"))){
                //어떤값을 넣어야할지 애매하다.
            }
        }
        model.addAttribute("record",all);//다른값을 넣어야한다.
        return "record/record";
    }//로그인마다 체크해야한다.확인

    @PostMapping("/record")
    public String checkRecord(@ModelAttribute("record")Record record){
        return "redirect:/record";
    }
}
