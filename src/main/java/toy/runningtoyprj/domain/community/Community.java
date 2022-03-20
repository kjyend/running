package toy.runningtoyprj.domain.community;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Community {

    @Id @GeneratedValue
    private String id;

    private Long time;
    private String startPlace;
    private String endPlace;
    private Long street;//km수
}
