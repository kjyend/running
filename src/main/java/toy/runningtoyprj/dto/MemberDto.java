package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;
import toy.runningtoyprj.domain.entity.Member;

@Getter
public class MemberDto {
    private Long id;

    private String loginId;
    private String password;
    private String name;
    private String dob;

    @Builder
    public MemberDto(Long id, String loginId, String password, String name, String dob) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.dob = dob;
    }

    public Member toMemberEntity(){
        return Member.builder()
                .id(id)
                .loginId(loginId)
                .password(password)
                .name(name)
                .dob(dob)
                .build();
    }
}
