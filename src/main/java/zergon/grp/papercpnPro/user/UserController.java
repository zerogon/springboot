package zergon.grp.papercpnPro.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@GetMapping("hello")
	public String hello(Model model) {
			model.addAttribute("data", "test성공");
		return "hello";
	}
	
	@GetMapping("json")
	@ResponseBody
	public Person json(@RequestParam(defaultValue = "df_value")String name ) {
		Person person = new Person();
		person.setName("zerogon");
		return person;
	}
	
	static class Person{
		private String name ;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
}
