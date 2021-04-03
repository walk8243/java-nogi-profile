package xyz.walk8243.nogiprofile.api.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

public class SongExInfo extends Song {
	@Getter @Setter
	private List<Discography> discographies;

	public SongExInfo(Song song, List<SongsOnDisc> songsOnDiscsList) {
		this.setId(song.getId());
		this.setName(song.getName());
		this.setDiscographies(this.convertToDiscographiesFromSongsOnDiscList(songsOnDiscsList));
	}

	private List<Discography> convertToDiscographiesFromSongsOnDiscList(List<SongsOnDisc> songsOnDiscsList) {
		return songsOnDiscsList
			.stream()
			.map(songsOnDisc -> { return songsOnDisc.getDiscography(); })
			.collect(Collectors.toList());
	}
}
