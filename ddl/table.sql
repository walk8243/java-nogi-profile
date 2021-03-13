CREATE TABLE member (
	id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(64) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE member_supplement (
	member_id MEDIUMINT UNSIGNED NOT NULL,
	kana VARCHAR(128) NOT NULL,
	class TINYINT UNSIGNED NOT NULL,
	birthday DATE NOT NULL,
	bloodtype ENUM('A', 'B', 'O', 'AB'),
	PRIMARY KEY (member_id),
	FOREIGN KEY (member_id)
		REFERENCES member(id)
		ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE album (
	id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE song (
	id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE song_table (
	album_id MEDIUMINT UNSIGNED NOT NULL,
	song_id MEDIUMINT UNSIGNED NOT NULL,
	PRIMARY KEY (song_id, album_id),
	FOREIGN KEY (album_id)
		REFERENCES album(id)
		ON DELETE CASCADE,
	FOREIGN KEY (song_id)
		REFERENCES song(id)
		ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;

CREATE VIEW member_info
	AS SELECT member.id, member.name, member_supplement.kana, member_supplement.class, member_supplement.birthday, member_supplement.bloodtype
		FROM member
		INNER JOIN member_supplement ON member.id = member_supplement.member_id;
