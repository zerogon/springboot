package zergon.grp.papercpnPro.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zergon.grp.papercpnPro.member.repo.MemberRepo;
import zergon.grp.papercpnPro.member.repo.impl.JdbcMemberRepoImpl;
import zergon.grp.papercpnPro.member.repo.impl.MemoryMemberRepoImpl;
import zergon.grp.papercpnPro.member.service.MemberService;

@Configuration
public class SpringConfig {

	private final DataSource dataSource;

	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepo());
	}

	@Bean
	public MemberRepo memberRepo() {
		//return new MemoryMemberRepoImpl();
		return new JdbcMemberRepoImpl(dataSource);
	}


}
