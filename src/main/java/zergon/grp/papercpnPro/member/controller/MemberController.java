package zergon.grp.papercpnPro.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zergon.grp.papercpnPro.member.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	

	
}
