package toy.runningtoyprj.domain.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.runningtoyprj.domain.member.MemberRepository;


@Service
@Transactional
public class RecordService {

    @Autowired RecordRepository recordRepository;

    @Autowired
    MemberRepository memberRepository;

    public void saveRecord(Record record){
        record.setMember(memberRepository.memberUpdate(record));
        recordRepository.save(record);
    }

}
