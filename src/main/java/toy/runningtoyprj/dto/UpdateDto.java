package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateDto {
    private Long id;

    private String loginId;
    private String password;
    private String name;
    private String dob;
}
