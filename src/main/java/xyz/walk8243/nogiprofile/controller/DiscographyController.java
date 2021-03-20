package xyz.walk8243.nogiprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.model.SongsOnDisc;
import xyz.walk8243.nogiprofile.repository.SongsOnDiscRepository;

@Controller
@RequestMapping(path = "/disc")
public class DiscographyController {
	@Autowired
	private SongsOnDiscRepository songsOnDiscRepository;

	@GetMapping(path = "/songs/{value}")
	public @ResponseBody List<SongsOnDisc> getSongsOnDisc(@PathVariable("value") Integer discographyId) {
		return songsOnDiscRepository.findByDiscographyId(discographyId);
	}
}
