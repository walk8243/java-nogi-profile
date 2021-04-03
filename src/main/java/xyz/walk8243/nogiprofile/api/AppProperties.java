package xyz.walk8243.nogiprofile.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	@Getter @Setter
	private String name = "nogiprofile-api";
}
