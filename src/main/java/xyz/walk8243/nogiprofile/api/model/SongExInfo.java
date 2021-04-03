package xyz.walk8243.nogiprofile.api.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

public class SongExInfo extends Song {
	@Getter @Setter
	private List<Discography> discographies;

	public void setSongsOnDisc(List<SongsOnDisc> songsOnDiscsList) {
		List<Discography> discs = convertToDiscographiesFromSongsOnDiscList(songsOnDiscsList);
		setDiscographies(discs);
	}

	public static SongExInfo cast(Song song) {
		SongExInfo exInfo = new SongExInfo();
		exInfo.setId(song.getId());
		exInfo.setName(song.getName());
		return exInfo;
	}

	private List<Discography> convertToDiscographiesFromSongsOnDiscList(List<SongsOnDisc> songsOnDiscsList) {
		return songsOnDiscsList
			.stream()
			.map(songsOnDisc -> convertToDiscographyFromSongsOnDiscList(songsOnDisc))
			.collect(Collectors.toList());
	}

	private Discography convertToDiscographyFromSongsOnDiscList(SongsOnDisc songsOnDisc) {
		return songsOnDisc.getDiscography();
	}
}
