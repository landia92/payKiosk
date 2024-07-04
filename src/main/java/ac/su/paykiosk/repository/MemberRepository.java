package ac.su.paykiosk.repository;

import ac.su.paykiosk.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
