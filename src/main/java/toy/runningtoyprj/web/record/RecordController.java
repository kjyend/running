package toy.runningtoyprj.web.record;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.record.Record;
import toy.runningtoyprj.domain.record.RecordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

        List<Record> recordList = recordService.checkMember((Long) session.getAttribute("memberId"), all);

        model.addAttribute("record",recordList);
        return "record/record";
    }

    @PostMapping("/record")
    public String checkRecord(@ModelAttribute("record")Record record){
        return "redirect:/record";
    }
}
