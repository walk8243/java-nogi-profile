package xyz.walk8243.nogiprofile.api.model;

import java.util.List;
import java.util.stream.Collectors;

public class SongExInfo extends Song {
	private List<Discography> discographies;

	public SongExInfo(Song song, List<SongsOnDisc> songsOnDiscsList) {
		this.setId(song.getId());
		this.setName(song.getName());
		this.setDiscographies(this.convertToDiscographiesFromSongsOnDiscList(songsOnDiscsList));
	}

	public List<Discography> getDiscographies() {
		return discographies;
	}

	public void setDiscographies(List<Discography> discographies) {
		this.discographies = discographies;
	}

	private List<Discography> convertToDiscographiesFromSongsOnDiscList(List<SongsOnDisc> songsOnDiscsList) {
		return songsOnDiscsList
			.stream()
			.map(songsOnDisc -> { return songsOnDisc.getDiscography(); })
			.collect(Collectors.toList());
	}
}
