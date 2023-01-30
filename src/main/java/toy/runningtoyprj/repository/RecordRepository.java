package toy.runningtoyprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.runningtoyprj.domain.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

}
