package xyz.walk8243.nogiprofile.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="member_info")
public class MemberInfo {
	@Id
	@Column(name = "id")
	@Getter @Setter
	private Integer memberId;

	@Column(name = "name")
	@Getter @Setter
	private String name;

	@Column(name = "kana")
	@Getter @Setter
	private String kana;

	@Column(name = "class")
	@Getter @Setter
	private Integer memberClass;

	@Column(name = "birthday")
	@Getter @Setter
	private String birthday;

	@Column(name = "bloodtype")
	@Getter @Setter
	private String bloodtype;
}
