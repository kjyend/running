package toy.runningtoyprj.domain.record;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@Slf4j
public class RecordService {

    @Autowired RecordRepository recordRepository;


    public void saveRecord(Record record, Member member){
        record.setMember(member);
        recordRepository.save(record);
    }

    //tostring 해야함
    public List<Record> findRecord(Object memberId){
        List<Record> all = recordRepository.findAll();
        List<Record> recordList = null;
        log.info("222=={}",memberId);
        for (Record record : all) {
            log.info("111=={}",record.getMember());
            if(memberId.equals(record.getMember().toString())){
                recordList= (List<Record>) record;
            }
        }
        log.info("=={}",recordList);
        return recordList;
    }

    public Optional<Record> fineOne(Long id){
        return recordRepository.findById(id);
    }

    public List<Record> findAll(){
        return recordRepository.findAll();
    }

     //member값을 가지고 물품들을 조회해야한다.

}
