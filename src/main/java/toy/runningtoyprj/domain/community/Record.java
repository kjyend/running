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
    private Long street;//km수
    @Column
    private Long minuteTime;//기록 시간
    @Column
    private Long secondTime;

    @Column
    private Long dateTime;//날짜 시간

    @ManyToOne(targetEntity = Member.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}