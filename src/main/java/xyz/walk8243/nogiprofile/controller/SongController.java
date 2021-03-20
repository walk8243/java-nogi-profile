package xyz.walk8243.nogiprofile.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.model.Song;
import xyz.walk8243.nogiprofile.repository.SongRepository;

@Controller
@RequestMapping(path = "/song")
public class SongController {
	@Autowired
	private SongRepository songRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Song> getAllSongs() {
		return songRepository.findAll();
	}

	@GetMapping(path = "/{value}")
	public @ResponseBody Optional<Song> getSong(@PathVariable("value") Integer songId) {
		return songRepository.findById(songId);
	}
}
