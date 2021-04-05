package xyz.walk8243.nogiprofile.api;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import xyz.walk8243.nogiprofile.api.AppProperties.MysqlProperties;

@Configuration
public class MySQLConfiguration {
	private final Logger logger = LoggerFactory.getLogger(MySQLConfiguration.class);

	@Bean
	DataSource dataSource(AppProperties appProperties) {
		MysqlProperties mysqlProperties = appProperties.getMysql();
		logger.debug(mysqlProperties.toLogStr());

		DriverManagerDataSource dataSource = new DriverManagerDataSource(
			"jdbc:mysql://" + mysqlProperties.getHost() + ":3306/" + mysqlProperties.getDatabase(),
			mysqlProperties.getUsername(),
			mysqlProperties.getPassword()
		);
		return dataSource;
	}
}
