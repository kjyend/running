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


    public void saveRecord(Record record, Member member){// 기록을 저장할때 연동된 member 값을 같이 저장한다.
        record.setMember(member);
        recordRepository.save(record);
    }

    public List<Record> findAll(){
        return recordRepository.findAll();
    }

    public List<Record> checkMember(Long id,List<Record> record){//record 중 member 값을 통해서 기록에 자신의 것만 게시하게 한다.
        List<Record> checkUser=new ArrayList<>();
        for (Record records : record) {
            if(records.getMember().getId().equals(id)){
                checkUser.add(records);
            }
        }
        return checkUser;
    }

}
