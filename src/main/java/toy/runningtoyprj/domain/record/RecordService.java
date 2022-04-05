package toy.runningtoyprj.domain.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecordService {

    @Autowired RecordRepository recordRepository;

    public void saveRecord(Record record){
        recordRepository.save(record);
    }
}
