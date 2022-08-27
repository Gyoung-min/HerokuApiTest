package test.herokut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.herokut.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {


}
