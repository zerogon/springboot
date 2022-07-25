package zergon.grp.papercpnPro.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zergon.grp.papercpnPro.member.repo.MemberRepo;
import zergon.grp.papercpnPro.member.repo.MemberVO;

@Service
public class MemberService {
	private final MemberRepo memberRepo;
	
	@Autowired
	public MemberService(MemberRepo memberRepo) {
		this.memberRepo = memberRepo;
	}

	/**
	 * 회원가입
	 */
	public Long join(MemberVO member) {
		validateDuplicateMember(member); // 중복 회원 검증
		memberRepo.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(MemberVO member) {
		memberRepo.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	/**
	 * 전체 회원 조회
	 */
	public List<MemberVO> findMembers() {
		return memberRepo.findAll();
	}

	public Optional<MemberVO> findOne(Long memberId) {
		return memberRepo.findById(memberId);
	}
}
