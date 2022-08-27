package test.herokut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.herokut.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


}
