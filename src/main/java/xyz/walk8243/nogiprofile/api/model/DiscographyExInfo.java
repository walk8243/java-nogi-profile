package xyz.walk8243.nogiprofile.api.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

public class DiscographyExInfo extends Discography {
	@Getter @Setter List<SongOnDisc> songs;

	public DiscographyExInfo(Discography discography, List<SongsOnDisc> songsOnDiscsList) {
		this.setId(discography.getId());
		this.setName(discography.getName());
		this.setType(discography.getType());
		this.setSongs(this.convertToSongsFromSongsOnDiscList(songsOnDiscsList));
	}

	private List<SongOnDisc> convertToSongsFromSongsOnDiscList(List<SongsOnDisc> songsOnDiscsList) {
		return songsOnDiscsList
			.stream()
			.map(songsOnDisc -> {
				SongOnDisc song = new SongOnDisc();
				song.setId(songsOnDisc.getSongId());
				song.setName(songsOnDisc.getSong().getName());
				song.setOrder(songsOnDisc.getOrderNo());
				return song;
			})
			.collect(Collectors.toList());
	}

	class SongOnDisc extends Song {
		@Getter @Setter Integer order;
	}
}
