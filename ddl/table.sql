CREATE TABLE member (
	id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(64) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE member_supplement (
	member_id MEDIUMINT UNSIGNED NOT NULL,
	class TINYINT UNSIGNED NOT NULL,
	birthday DATE NOT NULL,
	PRIMARY KEY (member_id),
	FOREIGN KEY (member_id)
		REFERENCES member(id)
		ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;

CREATE VIEW member_info
	AS SELECT member.id, member.name, member_supplement.class, member_supplement.birthday
		FROM member
		INNER JOIN member_supplement ON member.id = member_supplement.member_id;
