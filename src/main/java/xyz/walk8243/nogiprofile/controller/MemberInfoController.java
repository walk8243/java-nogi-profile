package xyz.walk8243.nogiprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.model.MemberInfo;
import xyz.walk8243.nogiprofile.repository.MemberInfoRepository;

@Controller
@RequestMapping(path = "/member-info")
public class MemberInfoController {
	@Autowired
	private MemberInfoRepository memberInfoRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<MemberInfo> getAllMembers() {
		return memberInfoRepository.findAll();
	}
}
