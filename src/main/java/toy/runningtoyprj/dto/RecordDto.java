package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;
import toy.runningtoyprj.domain.entity.Member;

@Getter
public class RecordDto {

    private Long id;

    private Long street;
    private Long minuteTime;
    private String dateTime;
    private Member member;

    @Builder
    public RecordDto(Long id, Long street, Long minuteTime, String dateTime, Member member) {
        this.id = id;
        this.street = street;
        this.minuteTime = minuteTime;
        this.dateTime = dateTime;
        this.member = member;
    }
}
