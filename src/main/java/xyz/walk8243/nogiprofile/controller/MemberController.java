package xyz.walk8243.nogiprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.repository.MemberRepository;
import xyz.walk8243.nogiprofile.model.Member;

@Controller
@RequestMapping(path = "/member")
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Member> getAllMembers() {
		return memberRepository.findAll();
	}
}
