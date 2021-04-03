package xyz.walk8243.nogiprofile.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.walk8243.nogiprofile.api.model.Song;
import xyz.walk8243.nogiprofile.api.model.SongExInfo;
import xyz.walk8243.nogiprofile.api.model.SongsOnDisc;
import xyz.walk8243.nogiprofile.api.repository.SongRepository;
import xyz.walk8243.nogiprofile.api.repository.SongsOnDiscRepository;
import xyz.walk8243.nogiprofile.api.util.ListUtil;

@Service
public class SongService {
	@Autowired
	private SongRepository songRepository;

	@Autowired
	private SongsOnDiscRepository songsOnDiscRepository;

	public List<Song> getAll() {
		List<Song> songs = ListUtil.convertFromIterable(songRepository.findAll());
		return songs;
	}

	public Optional<Song> getById(Integer songId) {
		Optional<Song> song = songRepository.findById(songId);
		return song;
	}

	public Optional<SongExInfo> getSongExInfoById(Integer songId) {
		Optional<Song> song = songRepository.findById(songId);
		if(song.isPresent() == false) {
			return Optional.empty();
		}
		List<SongsOnDisc> songsOnDiscsList = songsOnDiscRepository.findBySongId(songId);
		SongExInfo info = new SongExInfo(song.get(), songsOnDiscsList);
		return Optional.of(info);
	}
}
