package toy.runningtoyprj.domain.community;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class RecordRepository implements JpaRepository<Record, Long> {

}
