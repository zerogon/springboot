package zergon.grp.papercpnPro.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import zergon.grp.papercpnPro.member.service.MemberService;

@Controller
public class CustomerController {

	private final MemberService memberService;

	public CustomerController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/customer/main")
	public final String main() {
		return "customer/main";
	}
	@GetMapping("/customer/status")
	public final String status() {
		return "customer/status";
	}
/*
	@PostMapping(value = "/member/new")
	public String createMember(MemberVO memberVO) {
		memberService.join(memberVO);
		return "redirect:/";
	}
	
	@GetMapping(value = "/member/list")
	public String memberList(Model model) {
	 List<MemberVO> members = memberService.findMembers();
	 model.addAttribute("members", members);
	 return "member/memberList";
	}
*/
}
