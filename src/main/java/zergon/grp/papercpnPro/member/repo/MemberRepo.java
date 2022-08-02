package zergon.grp.papercpnPro.member.repo;

import java.util.List;
import java.util.Optional;

public interface MemberRepo {
	 /*
	  *   구현체
	  *   메모리  -  MemoryMemberRepoImpl
	  *   JDBC  - JdbcMemberRepoImpl
	  *   JDBC 템플릿 - JdbcTemplateMemberRepoImpl
	  *   JPA - JpaMemberRepoImpl
	  */  
	 MemberVO save(MemberVO member);
	 Optional<MemberVO> findById(Long id);
	 Optional<MemberVO> findByName(String name);
	 List<MemberVO> findAll();
}
