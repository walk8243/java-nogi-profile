package xyz.walk8243.nogiprofile.api.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class SongsOnDiscPK implements Serializable {
	static final long serialVersionUID = 52174692L;

	@Getter @Setter
	private Integer discographyId;

	@Getter @Setter
	private Integer songId;

	public int hashcode() {
		return (this.discographyId << 8 * 3) + this.songId;
	}

	public boolean equals(Object obj) {
		return this.hashCode() == ((SongsOnDiscPK) obj).hashCode();
	}
}
