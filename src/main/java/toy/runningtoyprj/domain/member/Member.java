package toy.runningtoyprj.domain.member;

import lombok.Getter;
import lombok.Setter;
import toy.runningtoyprj.domain.community.Record;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "MEMBER")
public class Member {

    @Id @GeneratedValue
    @Column
    private Long id;

    @Column
    private String loginId;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String DOB;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
    private List<Record> record;

}
