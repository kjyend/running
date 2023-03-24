package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class LoginDto {

    private Long id;
    @NotBlank
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String loginId;
    @NotBlank
    @Size(min = 2,max=20, message = "비밀번호를 2-20자 사이로 입력해주세요")
    private String password;

    @Builder
    public LoginDto(Long id, String loginId, String password) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
    }
}
