package toy.runningtoyprj.domain.entity;

import lombok.*;
import toy.runningtoyprj.dto.LoginDto;
import toy.runningtoyprj.dto.MemberDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="member_id")
    private Long id;

    private String loginId;//로그인 아이디
    private String name; // 이름
    private String password; //패스워드
    private String dob; // 출생월일

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "member")
    private List<Record> records=new ArrayList<>(); //기록과 연동

    @Builder
    public Member(Long id, String loginId, String name, String password, String dob, List<Record> records) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.dob = dob;
        this.records = records;
    }

    public MemberDto toMemberDto(){
        return MemberDto.builder()
                .id(id)
                .loginId(loginId)
                .password(password)
                .name(name)
                .dob(dob)
                .build();
    }

    public LoginDto toLoginDto(){
        return LoginDto.builder()
                .id(id)
                .loginId(loginId)
                .password(password)
                .build();
    }
}
