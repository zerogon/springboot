package zergon.grp.papercpnPro.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zergon.grp.papercpnPro.member.repo.MemberRepo;
import zergon.grp.papercpnPro.member.repo.impl.JdbcMemberRepoImpl;
import zergon.grp.papercpnPro.member.repo.impl.JdbcTemplateMemberRepoImpl;
import zergon.grp.papercpnPro.member.repo.impl.JpaMemberRepoImpl;
import zergon.grp.papercpnPro.member.repo.impl.MemoryMemberRepoImpl;
import zergon.grp.papercpnPro.member.service.MemberService;

@Configuration
public class SpringConfig {

	/*
	 * -----jpa 생성자 
	 * 
	 * private final DataSource dataSource; private final EntityManager em;
	 * 
	 * public SpringConfig(DataSource dataSource, EntityManager em) {
	 * this.dataSource = dataSource; this.em = em; }
	 */
	private final MemberRepo memberRepo;

	public SpringConfig(MemberRepo memberRepo) {
		this.memberRepo = memberRepo;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepo);
	}
	
	/*
	@Bean
	public MemberRepo memberRepo() {
		// return new MemoryMemberRepoImpl();
		// return new JdbcMemberRepoImpl(dataSource);
		// return new JdbcTemplateMemberRepoImpl(dataSource);
		return new JpaMemberRepoImpl(em);
	}
	*/

}
