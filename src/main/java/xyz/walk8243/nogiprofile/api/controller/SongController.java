package xyz.walk8243.nogiprofile.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.walk8243.nogiprofile.api.model.Song;
import xyz.walk8243.nogiprofile.api.model.SongExInfo;
import xyz.walk8243.nogiprofile.api.service.SongService;

@Controller
@RequestMapping(path = "/song")
public class SongController {
	@Autowired
	private SongService songService;

	@GetMapping(path = "/all")
	public @ResponseBody List<Song> getAllSongs() {
		return songService.getAll();
	}

	@GetMapping(path = "/{value}")
	public @ResponseBody Optional<Song> getSong(@PathVariable("value") Integer songId) {
		return songService.getById(songId);
	}

	@GetMapping(path = "/discs/{value}")
	public @ResponseBody Optional<SongExInfo> getSongExInfo(@PathVariable("value") Integer songId) {
		return songService.getSongExInfoById(songId);

	}
}
