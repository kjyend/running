package toy.runningtoyprj.domain.member;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import toy.runningtoyprj.domain.record.Record;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "MEMBER")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String loginId;//로그인 아이디
    @Column
    private String name; // 이름
    @Column
    private String password; //패스워드
    @Column
    private String dob; // 출생월일

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
    private List<Record> records=new ArrayList<>(); //기록과 연동


}
