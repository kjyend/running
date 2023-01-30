package toy.runningtoyprj.domain.entity;


import lombok.*;


import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Record {

    @Id @GeneratedValue
    @Column(name="record_id")
    private Long id;

    private Long street;//m수
    private Long minuteTime;//기록 시간
    private String dateTime;//날짜 시간

    @ManyToOne
    @JoinColumn(name = "member")
    private Member member;

    @Builder
    public Record(Long id, Long street, Long minuteTime, String dateTime, Member member) {
        this.id = id;
        this.street = street;
        this.minuteTime = minuteTime;
        this.dateTime = dateTime;
        this.member = member;
    }
}
