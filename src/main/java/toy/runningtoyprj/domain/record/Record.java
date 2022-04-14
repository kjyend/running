package toy.runningtoyprj.domain.record;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import toy.runningtoyprj.domain.member.Member;

import javax.persistence.*;


@Entity
@Getter @Setter
@Table(name = "RECORD")
@Slf4j
public class Record {

    @Id @GeneratedValue
    @Column(name="record_id")
    private Long id;

    @Column
    private Long street;//km수
    @Column
    private Long minuteTime;//기록 시간

    @Column
    private String dateTime;//날짜 시간

    @ManyToOne(targetEntity = Member.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    private Member member;


}
