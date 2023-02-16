package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;
import toy.runningtoyprj.domain.entity.Member;

@Getter
@Builder
public class RecordDto {

    private Long id;

    private Long street;
    private Long minuteTime;
    private String dateTime;
    private Member member;
}
