package xyz.walk8243.nogiprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired
	private MemberRepository memberRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Member> getAllUsers() {
		return memberRepository.findAll();
	}
}
