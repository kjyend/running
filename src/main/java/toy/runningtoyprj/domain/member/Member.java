package toy.runningtoyprj.domain.member;

import lombok.Getter;
import lombok.Setter;
import toy.runningtoyprj.domain.record.Record;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "MEMBER")
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @Column
    private String loginId;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String dob;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
    @Column
    private List<Record> record;

}
