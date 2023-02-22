package toy.runningtoyprj.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import toy.runningtoyprj.domain.entity.Member;
import toy.runningtoyprj.domain.entity.Record;
import toy.runningtoyprj.dto.RecordDto;
import toy.runningtoyprj.service.RecordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @GetMapping("/check")
    public String checkForm(RecordDto recordDto,Model model){
        model.addAttribute("record", recordDto);
        return "record/check"; //기록측정 form
    }

    @PostMapping("/check")
    public String saveCheck(RecordDto recordDto, HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        recordService.saveRecord(recordDto, (Member) session.getAttribute("loginMember"));//세션값을 통해서 누구인지 알고 기록을 측정한다.
        return "redirect:/check";
    }

    @GetMapping("/record")
    public String community(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Record> all = recordService.findAll(); //모든 기록을 조회
        List<Record> recordList = recordService.checkMember((Long) session.getAttribute("memberId"), all);//모든 기록중 member 본인의 기록을 조회
        
        model.addAttribute("record",recordList);
        return "record/record";
    }
}
