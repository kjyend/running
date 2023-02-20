package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateDto {
    private Long id;

    private String loginId;
    private String password;
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
