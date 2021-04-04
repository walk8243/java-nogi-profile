package xyz.walk8243.nogiprofile.api;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MySQLConfiguration {
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(
			"jdbc:mysql://mysql:3306/nogizaka",
			"walk8243",
			"shLG425x"
		);
		return dataSource;
	}
}
