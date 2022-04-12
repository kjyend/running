package toy.runningtoyprj.domain.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.runningtoyprj.domain.member.Member;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RecordService {

    @Autowired RecordRepository recordRepository;

    public void saveRecord(Record record, Member member){
        record.setMember(member);
        recordRepository.save(record);
    }

    public List<Record> findRecord(){
        return recordRepository.findAll();
    }

    public Optional<Record> fineOne(Long id){
        return recordRepository.findById(id);
    }

}
