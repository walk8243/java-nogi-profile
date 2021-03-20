package xyz.walk8243.nogiprofile.model;

import java.util.List;

public class DiscographyExInfo extends Discography {
	private List<SongsOnDisc> songsOnDiscsList;

	public DiscographyExInfo(Discography discography, List<SongsOnDisc> songsOnDiscsList) {
		this.setId(discography.getId());
		this.setName(discography.getName());
		this.setType(discography.getType());
		this.setSongsOnDiscList(songsOnDiscsList);
	}

	public List<SongsOnDisc> getSongsOnDiscList() {
		return songsOnDiscsList;
	}

	public void setSongsOnDiscList(List<SongsOnDisc> songsOnDiscsList) {
		this.songsOnDiscsList = songsOnDiscsList;
	}
}
