package xyz.walk8243.nogiprofile.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	@Autowired
	RestTemplate restTemplate;

	@Getter @Setter private String name = "nogiprofile-api";
	@Getter @Setter private String env;
	@Getter private MysqlProperties mysql = new MysqlProperties();
	@Getter private KeyStoreProperties keystore = new KeyStoreProperties();

	public class MysqlProperties {
		@Getter @Setter private String host;
		@Getter @Setter private String database;
		@Getter @Setter private String username;
		@Getter private String password;
		@Getter @Setter private KeyStoreConfig passkey = new KeyStoreConfig();

		public void setPassword(String password) {
			if(password.isEmpty()) {
				if(passkey.validate()) {
					this.password = restTemplate.getForObject(keystore.getUrl() + "?group=" + passkey.getGroup() + "&key=" + passkey.getKey(), String.class);
				}
			} else {
				this.password = password;
			}
		}

		public String toLogStr() {
			return "{host: " + host + ", database: " + database + ", username: " + username + "}";
		}
	}

	public class KeyStoreConfig {
		@Getter @Setter private String group;
		@Getter @Setter private String key;

		public boolean validate() {
			if(group.isEmpty() || key.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}
	}

	public class KeyStoreProperties {
		@Getter @Setter private String url;
	}
}
