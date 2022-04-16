package toy.runningtoyprj.domain.record;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.runningtoyprj.domain.member.Member;
import toy.runningtoyprj.domain.member.MemberRepository;

import java.util.ArrayList;
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


    public Optional<Record> fineOne(Long id){
        return recordRepository.findById(id);
    }

    public List<Record> findAll(){
        return recordRepository.findAll();
    }

    public List<Record> checkMember(Long id,List<Record> record){
        List<Record> checkUser=new ArrayList<>();
        for (Record records : record) {
            if(records.getMember().getId().equals(id)){
                checkUser.add(records);
            }
        }
        return checkUser;
    }

}
