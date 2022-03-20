package toy.runningtoyprj.domain.profile;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Profile {
    @Id
    @GeneratedValue
    private String id;

    private String name;
    private String title;
    private Long dateTime;
    private String comment;
    private Long see;
}
