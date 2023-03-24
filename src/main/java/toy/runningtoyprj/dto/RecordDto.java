package toy.runningtoyprj.dto;

import lombok.Builder;
import lombok.Getter;
import toy.runningtoyprj.domain.entity.Member;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class RecordDto {

    private Long id;

    @NotBlank
    @Min(2)
    private Long street;
    @NotBlank
    private Long minuteTime;
    @NotBlank
    @Min(2)
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
