package zergon.grp.papercpnPro.member.repo;

import java.util.List;
import java.util.Optional;

public interface MemberRepo {
	 MemberVO save(MemberVO member);
	 Optional<MemberVO> findById(Long id);
	 Optional<MemberVO> findByName(String name);
	 List<MemberVO> findAll();
}
