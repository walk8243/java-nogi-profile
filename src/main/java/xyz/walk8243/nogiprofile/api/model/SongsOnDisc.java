package xyz.walk8243.nogiprofile.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@IdClass(SongsOnDiscPK.class)
@Table(name = "songs_on_disc")
public class SongsOnDisc {
	@Id
	@Column(columnDefinition = "discography_id")
	@Getter @Setter
	private Integer discographyId;

	@Id
	@Column(columnDefinition = "song_id")
	@Getter @Setter
	private Integer songId;

	@Column(columnDefinition = "order_no")
	@Getter @Setter
	private Integer orderNo;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "discographyId", referencedColumnName = "id", insertable = false, updatable = false)
	@Getter @Setter
	private Discography discography;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "songId", referencedColumnName = "id", insertable = false, updatable = false)
	@Getter @Setter
	private Song song;
}
