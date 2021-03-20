package xyz.walk8243.nogiprofile.model;

import java.util.List;

public class SongExInfo extends Song {
	private List<SongsOnDisc> songsOnDiscsList;

	public SongExInfo(Song song, List<SongsOnDisc> songsOnDiscsList) {
		this.setId(song.getId());
		this.setName(song.getName());
		this.setSongsOnDiscList(songsOnDiscsList);
	}

	public List<SongsOnDisc> getSongsOnDiscList() {
		return songsOnDiscsList;
	}

	public void setSongsOnDiscList(List<SongsOnDisc> songsOnDiscsList) {
		this.songsOnDiscsList = songsOnDiscsList;
	}
}
