package zergon.grp.papercpnPro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zergon.grp.papercpnPro.member.repo.MemberRepo;
import zergon.grp.papercpnPro.member.repo.impl.MemoryMemberRepoImpl;
import zergon.grp.papercpnPro.member.service.MemberService;

@Configuration
public class SpringConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepo());
	}
	
	@Bean
	public MemberRepo memberRepo() {
		return new MemoryMemberRepoImpl();
	}

}
