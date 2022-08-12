package zergon.grp.papercpnPro.owner.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import zergon.grp.papercpnPro.member.repo.MemberVO;
import zergon.grp.papercpnPro.member.service.MemberService;

@Controller
public class OwnerController {

	private final MemberService memberService;

	public OwnerController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/owner/main")
	public final String main() {
		return "owner/main";
	}
	@GetMapping("/owner/admin")
	public final String admin() {
		return "owner/admin";
	}
	@GetMapping("/owner/history")
	public final String history() {
		return "owner/history";
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
