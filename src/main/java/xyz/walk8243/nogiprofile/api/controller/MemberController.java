package xyz.walk8243.nogiprofile.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.api.model.MemberInfo;
import xyz.walk8243.nogiprofile.api.repository.MemberInfoRepository;

@Controller
@RequestMapping(path = "/member")
public class MemberController {
	@Autowired
	private MemberInfoRepository memberInfoRepository;

	@GetMapping(path = {"", "/", "/all"})
	public @ResponseBody Iterable<MemberInfo> getAllMembers() {
		return memberInfoRepository.findAll();
	}

	@GetMapping(path = "/class")
	public @ResponseBody Iterable<MemberInfo> getMembersByClassForQuery(@RequestParam("value") Integer memberClass) {
		return memberInfoRepository.findByMemberClass(memberClass);
	}

	@GetMapping(path = "/class/{value}")
	public @ResponseBody Iterable<MemberInfo> getMembersByClassForPath(@PathVariable("value") Integer memberClass) {
		return memberInfoRepository.findByMemberClass(memberClass);
	}
}
