package toy.runningtoyprj.web.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.runningtoyprj.domain.record.Record;
import toy.runningtoyprj.domain.record.RecordRepository;
import toy.runningtoyprj.domain.record.RecordService;


@Controller
@Transactional
public class RecordController {

    @Autowired
    RecordService recordService;

    @GetMapping("/record")
    public String community(@ModelAttribute("record") Record record){

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
