package xyz.walk8243.nogiprofile.api.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class DiscographyExInfo extends Discography {
	@Getter @Setter List<SongOnDisc> songs;

	public void setSongsOnDisc(List<SongsOnDisc> songsOnDiscsList) {
		List<SongOnDisc> songs = convertToSongFromSongsOnDiscList(songsOnDiscsList);
		setSongs(songs);
	}

	public static DiscographyExInfo cast(Discography discography) {
		DiscographyExInfo exInfo = new DiscographyExInfo();
		exInfo.setId(discography.getId());
		exInfo.setName(discography.getName());
		exInfo.setType(discography.getType());
		return exInfo;
	}

	private List<SongOnDisc> convertToSongFromSongsOnDiscList(List<SongsOnDisc> songsOnDiscsList) {
		return songsOnDiscsList
			.stream()
			.map(songsOnDisc -> convertToSongFromSongsOnDisc(songsOnDisc))
			.collect(Collectors.toList());
	}

	private SongOnDisc convertToSongFromSongsOnDisc(SongsOnDisc songsOnDisc) {
		SongOnDisc song = new SongOnDisc();
		song.setId(songsOnDisc.getSongId());
		song.setName(songsOnDisc.getSong().getName());
		song.setOrder(songsOnDisc.getOrderNo());
		return song;
	}

	class SongOnDisc extends Song {
		@Getter @Setter Integer order;
	}
}
