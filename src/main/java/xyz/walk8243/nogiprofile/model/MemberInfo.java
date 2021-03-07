package xyz.walk8243.nogiprofile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_info")
public class MemberInfo {
	@Id
	@Column(name = "id")
	private Integer memberId;

	@Column(name = "name")
	private String name;

	@Column(name = "class")
	private Integer memberClass;

	@Column(name = "birthday")
	private String birthday;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMemberClass() {
		return memberClass;
	}

	public void setMemberClass(Integer memberClass) {
		this.memberClass = memberClass;
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
