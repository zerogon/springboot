package zergon.grp.papercpnPro.user.service;

import java.util.List;
import java.util.Optional;

import zergon.grp.papercpnPro.user.service.impl.MemberVO;

public interface UserService {
	 MemberVO save(MemberVO member);
	 Optional<MemberVO> findById(Long id);
	 Optional<MemberVO> findByName(String name);
	 List<MemberVO> findAll();
}
