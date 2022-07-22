package zergon.grp.papercpnPro.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import zergon.grp.papercpnPro.user.service.UserService;

public class UserServiceImpl implements UserService {

	private static Map<Long, MemberVO> store = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public MemberVO save(MemberVO MemberVO) {
		MemberVO.setId(++sequence);
		store.put(MemberVO.getId(), MemberVO);
		return MemberVO;
	}

	@Override
	public Optional<MemberVO> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public List<MemberVO> findAll() {
		return new ArrayList<>(store.values());
	}

	@Override
	public Optional<MemberVO> findByName(String name) {
		return store.values().stream().filter(MemberVO -> MemberVO.getName().equals(name)).findAny();
	}

	public void clearStore() {
		store.clear();
	}
}
