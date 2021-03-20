package xyz.walk8243.nogiprofile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(SongsOnDiscPK.class)
@Table(name = "songs_on_disc")
public class SongsOnDisc {
	@Id
	@Column(columnDefinition = "discography_id")
	private Integer discographyId;

	@Id
	@Column(columnDefinition = "song_id")
	private Integer songId;

	@Column(columnDefinition = "order_no")
	private Integer orderNo;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "discographyId", referencedColumnName = "id", insertable = false, updatable = false)
	private Discography discography;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "songId", referencedColumnName = "id", insertable = false, updatable = false)
	private Song song;

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

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Discography getDiscography() {
		return discography;
	}

	public void setDiscography(Discography discography) {
		this.discography = discography;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
}
