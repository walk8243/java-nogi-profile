package xyz.walk8243.nogiprofile.model;

import java.util.List;
import java.util.stream.Collectors;

public class DiscographyExInfo extends Discography {
	private List<Song> songs;

	public DiscographyExInfo(Discography discography, List<SongsOnDisc> songsOnDiscsList) {
		this.setId(discography.getId());
		this.setName(discography.getName());
		this.setType(discography.getType());
		this.setSongs(this.convertToSongsFromSongsOnDiscList(songsOnDiscsList));
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	private List<Song> convertToSongsFromSongsOnDiscList(List<SongsOnDisc> songsOnDiscsList) {
		return songsOnDiscsList
			.stream()
			.map(songsOnDisc -> { return songsOnDisc.getSong(); })
			.collect(Collectors.toList());
	}
}
