package xyz.walk8243.nogiprofile.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.api.model.MemberInfo;
import xyz.walk8243.nogiprofile.api.service.MemberService;

@Controller
@RequestMapping(path = "/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping(path = {"", "/", "/all"})
	public @ResponseBody List<MemberInfo> getAllMembers() {
		return memberService.getAll();
	}

	@GetMapping(path = "/class")
	public @ResponseBody List<MemberInfo> getMembersByClassForQuery(@RequestParam("value") Integer memberClass) {
		return memberService.getAllByClass(memberClass);
	}

	@GetMapping(path = "/class/{value}")
	public @ResponseBody List<MemberInfo> getMembersByClassForPath(@PathVariable("value") Integer memberClass) {
		return memberService.getAllByClass(memberClass);
	}
}
