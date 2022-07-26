package zergon.grp.papercpnPro.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zergon.grp.papercpnPro.member.repo.MemberRepo;
import zergon.grp.papercpnPro.member.repo.impl.MemberRepoImpl;
import zergon.grp.papercpnPro.member.service.MemberService;

@Configuration
public class SpringConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepo());
	}
	
	@Bean
	public MemberRepo memberRepo() {
		return new MemberRepoImpl();
	}

}
