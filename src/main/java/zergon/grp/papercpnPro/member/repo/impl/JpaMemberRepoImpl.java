package zergon.grp.papercpnPro.member.repo.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import zergon.grp.papercpnPro.member.repo.MemberRepo;
import zergon.grp.papercpnPro.member.repo.MemberVO;

public class JpaMemberRepoImpl implements MemberRepo  {
	
	private final EntityManager em;
	
	public JpaMemberRepoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public MemberVO save(MemberVO member) {
		em.persist(member);
		return member;
	}

	@Override
	public Optional<MemberVO> findById(Long id) {
		MemberVO member = em.find(MemberVO.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<MemberVO> findByName(String name) {
		 List<MemberVO> result = em.createQuery("select m from Member m where m.name = :name", MemberVO.class)
				  .setParameter("name", name)
				  .getResultList();
				  return result.stream().findAny();
	}

	@Override
	public List<MemberVO> findAll() {
		return em.createQuery("select m from Member m", MemberVO.class)
		.getResultList();
	}

}
