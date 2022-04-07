package toy.runningtoyprj.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import toy.runningtoyprj.domain.record.Record;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class MemberRepository {

    @PersistenceContext EntityManager em;

    public void save(Member member){
        if(member.getId()==null) {
            em.persist(member);
        }else {
            em.merge(member);
        }
    }

    public Optional<Member> findByLoginId(String loginId){
        return findAll().stream().filter(m->m.getLoginId().equals(loginId)).findFirst();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }


    public Member memberUpdate(Record record){
        return Member.createRecord(record);
    }


}
