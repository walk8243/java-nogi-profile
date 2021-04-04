package xyz.walk8243.nogiprofile.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	@Getter @Setter private String name = "nogiprofile-api";
	@Getter private MysqlProperties mysql = new MysqlProperties();

	public class MysqlProperties {
		@Getter @Setter private String host;
		@Getter @Setter private String database;
		@Getter @Setter private String username;
		@Getter @Setter private String password;

		public String toLogStr() {
			return "{host: " + host + ", database: " + database + ", username: " + username + "}";
		}
	}
}
