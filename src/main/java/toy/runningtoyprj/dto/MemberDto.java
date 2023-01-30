package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;
import toy.runningtoyprj.domain.entity.Member;

@Getter
@Builder
public class MemberDto {
    private Long id;

    private String loginId;
    private String password;
    private String name;
    private String dob;

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
