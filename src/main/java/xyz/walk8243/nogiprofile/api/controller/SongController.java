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
import xyz.walk8243.nogiprofile.api.model.SongsOnDisc;
import xyz.walk8243.nogiprofile.api.repository.SongRepository;
import xyz.walk8243.nogiprofile.api.repository.SongsOnDiscRepository;

@Controller
@RequestMapping(path = "/song")
public class SongController {
	@Autowired
	private SongRepository songRepository;

	@Autowired
	private SongsOnDiscRepository songsOnDiscRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Song> getAllSongs() {
		return songRepository.findAll();
	}

	@GetMapping(path = "/{value}")
	public @ResponseBody Optional<Song> getSong(@PathVariable("value") Integer songId) {
		return songRepository.findById(songId);
	}

	@GetMapping(path = "/discs/{value}")
	public @ResponseBody Optional<SongExInfo> getSongExInfo(@PathVariable("value") Integer songId) {
		Optional<Song> song = songRepository.findById(songId);
		if(song.isPresent() == false) {
			return Optional.empty();
		}
		List<SongsOnDisc> songsOnDiscsList = songsOnDiscRepository.findBySongId(songId);
		SongExInfo info = new SongExInfo(song.get(), songsOnDiscsList);
		return Optional.of(info);
	}
}
