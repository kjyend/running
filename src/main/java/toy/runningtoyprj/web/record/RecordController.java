package toy.runningtoyprj.web.record;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import toy.runningtoyprj.domain.community.Record;


@Controller
@Transactional
public class RecordController {

    @GetMapping("/record")
    public String community(@ModelAttribute("record") Record record){
        return "record/record";
    }

}
