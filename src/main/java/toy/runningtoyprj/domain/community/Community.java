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

    private String startPlace;//시작 위치
    private String endPlace;// 종료 위치
    private Long street;//km수
    private Long dateTime;//날짜 시간
}
