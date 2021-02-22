package xyz.walk8243.nogiprofile;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class NogiProfileController {

	@GetMapping(path = "/")
	public @ResponseBody String get() {
		return HttpStatus.OK.getReasonPhrase();
	}
}
