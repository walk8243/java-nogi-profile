package xyz.walk8243.nogiprofile.api.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import xyz.walk8243.nogiprofile.api.AppProperties;

@Controller
@RequestMapping(path = "/")
@Slf4j
public class NogiProfileController {
	@Getter private AppProperties appProperties;
	@Getter private Random random;

	public NogiProfileController(AppProperties appProperties) {
		this.appProperties = appProperties;
		this.random = new Random();
	}

	@GetMapping(path = "/")
	public @ResponseBody String get() {
		return appProperties.getName() + ", " + appProperties.getEnv() + " OK";
	}

	@GetMapping(path = "/late")
	public @ResponseBody String late() {
		try {
			log.info("25秒待機");
			Thread.sleep(25 * 1000);
			log.info("待機終了");
		} catch (Exception e) {
			log.error("25秒待機に失敗しました。", e);
		}
		return "late 25seconds";
	}

	@GetMapping(path = "/random")
	public @ResponseBody String random() {
		if (random.nextInt(10) < 7) {
			return "OK";
		} else {
			throw new Error("");
		}
	}
}
