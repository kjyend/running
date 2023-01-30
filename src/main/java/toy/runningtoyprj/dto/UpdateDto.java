package toy.runningtoyprj.dto;

import lombok.Getter;

@Getter
public class UpdateDto {
    private Long id;

    private String loginId;
    private String password;
    private String name;
    private String dob;
}
