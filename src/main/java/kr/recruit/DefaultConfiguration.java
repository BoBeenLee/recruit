package kr.recruit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@Profile("default")
public class DefaultConfiguration {
	@Bean
	public SimpleDriverDataSource dataSource(){
		SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
		
		simpleDriverDataSource.setDriverClass(org.postgresql.Driver.class);
		simpleDriverDataSource.setUrl("jdbc:postgresql://localhost:5432/recruit");
		simpleDriverDataSource.setUsername("recruit");
		simpleDriverDataSource.setPassword("1234");
		
		return simpleDriverDataSource;
	}
}
