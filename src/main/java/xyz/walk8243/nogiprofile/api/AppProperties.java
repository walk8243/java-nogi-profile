package xyz.walk8243.nogiprofile.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	private String name = "nogiprofile-api";

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
