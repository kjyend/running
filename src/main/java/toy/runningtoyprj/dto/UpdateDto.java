package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
public class UpdateDto {
    private Long id;

    @NotBlank
    @Email
    private String loginId;
    @NotBlank
    @Min(3)
    private String password;
    @Min(2)
    private String name;
    private String dob;

    @Builder
    public UpdateDto(Long id, String loginId, String password, String name, String dob) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.dob = dob;
    }
}
