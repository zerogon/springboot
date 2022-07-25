package zergon.grp.papercpnPro.member.repo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import zergon.grp.papercpnPro.member.repo.MemberRepo;
import zergon.grp.papercpnPro.member.repo.MemberVO;

@Repository
public class MemberRepoImpl implements MemberRepo {

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
