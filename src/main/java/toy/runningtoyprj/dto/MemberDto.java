package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;
import toy.runningtoyprj.domain.entity.Member;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class MemberDto {
    private Long id;

    @NotBlank
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String loginId;
    @NotBlank
    @Size(min = 2,max=20, message = "비밀번호를 2-20자 사이로 입력해주세요")
    private String password;
    @Size(min=2)
    private String name;
    @Min(2)
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
