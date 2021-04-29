package xyz.walk8243.nogiprofile.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.api.AppProperties;

@Controller
@RequestMapping(path = "/")
public class NogiProfileController {
	@Autowired
	AppProperties appProperties;

	@GetMapping(path = "/")
	public @ResponseBody String get() {
		return appProperties.getName() + ", " + appProperties.getEnv() + " OK";
	}
}
