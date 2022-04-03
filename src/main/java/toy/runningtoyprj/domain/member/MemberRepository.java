package toy.runningtoyprj.domain.member;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
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

    public Optional<Member> MemberInformation(String loginId){
        Member member= em.find(Member.class,loginId);
        return Optional.ofNullable(member);//회원조회
    }
}
