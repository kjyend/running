package toy.runningtoyprj.domain.community;


import lombok.Getter;
import lombok.Setter;
import toy.runningtoyprj.domain.member.Member;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "RECORD")
public class Record {

    @Id @GeneratedValue
    private String id;

    @Column
    private String loginId;
    @Column
    private String startPlace;//시작 위치
    @Column
    private String endPlace;// 종료 위치
    @Column
    private Long street;//km수

    @Column
    private Long dateTime;//날짜 시간

    @ManyToOne(targetEntity = Member.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
