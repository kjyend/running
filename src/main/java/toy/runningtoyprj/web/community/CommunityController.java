package toy.runningtoyprj.web.community;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import toy.runningtoyprj.domain.community.Community;


@Controller
@Transactional
public class CommunityController {

    @GetMapping("/community")
    public String community(@ModelAttribute("community") Community community){
        return "community/community";
    }

}
