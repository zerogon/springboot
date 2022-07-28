package zergon.grp.papercpnPro.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public final String Home() {
		
		return "home";
	}
}
