package toy.runningtoyprj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.runningtoyprj.domain.entity.Member;
import toy.runningtoyprj.domain.entity.Record;
import toy.runningtoyprj.dto.RecordDto;
import toy.runningtoyprj.repository.RecordRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class RecordService {

    private final RecordRepository recordRepository;

    public void saveRecord(RecordDto record, Member member){// 기록을 저장할때 연동된 member 값을 같이 저장한다.
        //member값 변경해주어야 한다.
        Record saveRecord = Record.builder()
                .street(record.getStreet())
                .minuteTime(record.getMinuteTime())
                .dateTime(record.getDateTime())
                .member(member)
                .build();

        recordRepository.save(saveRecord);
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
