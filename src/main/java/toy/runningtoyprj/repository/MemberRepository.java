package toy.runningtoyprj.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import toy.runningtoyprj.domain.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class MemberRepository{

    @PersistenceContext EntityManager em;

    public void save(Member member){ // 회원을 db에 저장한다.
        if(member.getId()==null) {
            em.persist(member);
        }else {
            em.merge(member);
        }
    }

    public Optional<Member> findByLoginId(String loginId){//로그인 아이디 찾기
        return findAll().stream().filter(m->m.getLoginId().equals(loginId)).findFirst();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }

    // 메서드 하나 생성할것 쿼리날릴걸로 createQuery
    public Member findOne(Long member_id) {
        return em.find(Member.class, member_id);
    }

}
