package zergon.grp.papercpnPro.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import zergon.grp.papercpnPro.member.repo.MemberVO;
import zergon.grp.papercpnPro.member.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/member/new")
	public final String createMemberForm(MemberVO memberVO) {
		return "member/createMemberForm";
	}

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

}
