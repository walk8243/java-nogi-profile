package xyz.walk8243.nogiprofile.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.api.model.Discography;
import xyz.walk8243.nogiprofile.api.model.DiscographyExInfo;
import xyz.walk8243.nogiprofile.api.service.DiscographyService;

@Controller
@RequestMapping(path = "/disc")
public class DiscographyController {
	@Autowired
	private DiscographyService discographyService;

	@GetMapping(path = "/all")
	public @ResponseBody List<Discography> getAllDiscs() {
		return discographyService.getAll();
	}

	@GetMapping(path = "/{value}")
	public @ResponseBody Optional<Discography> getDisc(@PathVariable("value") Integer discId) {
		return discographyService.getById(discId);
	}

	@GetMapping(path = "/songs/{value}")
	public @ResponseBody Optional<DiscographyExInfo> getSongsOnDisc(@PathVariable("value") Integer discId) {
		return discographyService.getDiscExInfoById(discId);
	}
}
