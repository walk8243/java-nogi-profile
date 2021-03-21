package xyz.walk8243.nogiprofile.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/late")
public class LateController {
	private final Logger logger = LoggerFactory.getLogger(LateController.class);

	@GetMapping
	public @ResponseBody String get() {
		try {
			logger.info("25秒待機");
			Thread.sleep(25 * 1000);
			logger.info("待機終了");
		} catch (Exception e) {
			logger.error("25秒待機に失敗しました。", e);
		}
		return "late 25seconds";
	}
}
