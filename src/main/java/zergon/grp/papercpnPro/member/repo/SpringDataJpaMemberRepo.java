package zergon.grp.papercpnPro.member.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepo extends JpaRepository <MemberVO,Long>, MemberRepo {
	Optional<MemberVO> findByName(String name);
}
