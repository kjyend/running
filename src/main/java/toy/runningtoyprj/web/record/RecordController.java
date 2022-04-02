package toy.runningtoyprj.web.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import toy.runningtoyprj.domain.record.Record;
import toy.runningtoyprj.domain.record.RecordRepository;


@Controller
@Transactional
public class RecordController {

    @Autowired
    RecordRepository recordRepository;

    @GetMapping("/record")
    public String community(@ModelAttribute("record") Record record){
        return "record/record";
    }

    @GetMapping("/check")
    public String check(@ModelAttribute("record") Record record){
        recordRepository.save(record);
        return "record/check";
    }

}
