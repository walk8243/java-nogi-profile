package xyz.walk8243.nogiprofile.api.model;

import java.io.Serializable;

public class SongsOnDiscPK implements Serializable {
	static final long serialVersionUID = 52174692L;

	private Integer discographyId;

	private Integer songId;

	public Integer getDiscographyId() {
		return discographyId;
	}

	public void setDiscographyId(Integer discographyId) {
		this.discographyId = discographyId;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public int hashcode() {
		return (this.discographyId << 8 * 3) + this.songId;
	}

	public boolean equals(Object obj) {
		return this.hashCode() == ((SongsOnDiscPK) obj).hashCode();
	}
}
