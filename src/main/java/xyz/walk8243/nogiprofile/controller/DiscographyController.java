package xyz.walk8243.nogiprofile.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.model.Discography;
import xyz.walk8243.nogiprofile.model.DiscographyExInfo;
import xyz.walk8243.nogiprofile.model.SongsOnDisc;
import xyz.walk8243.nogiprofile.repository.DiscographyRepository;
import xyz.walk8243.nogiprofile.repository.SongsOnDiscRepository;

@Controller
@RequestMapping(path = "/disc")
public class DiscographyController {
	@Autowired
	private DiscographyRepository discographyRepository;

	@Autowired
	private SongsOnDiscRepository songsOnDiscRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Discography> getAllDiscs() {
		return discographyRepository.findAll();
	}

	@GetMapping(path = "/{value}")
	public @ResponseBody Optional<Discography> getDisc(@PathVariable("value") Integer discId) {
		return discographyRepository.findById(discId);
	}

	@GetMapping(path = "/songs/{value}")
	public @ResponseBody Optional<DiscographyExInfo> getSongsOnDisc(@PathVariable("value") Integer discographyId) {
		Optional<Discography> disc = discographyRepository.findById(discographyId);
		if(disc.isPresent() == false) {
			return Optional.empty();
		}
		List<SongsOnDisc> songsOnDiscsList = songsOnDiscRepository.findByDiscographyId(discographyId);
		DiscographyExInfo info = new DiscographyExInfo(disc.get(), songsOnDiscsList);
		return Optional.of(info);
	}
}
