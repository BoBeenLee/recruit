package kr.recruit;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
public class ProdConfiguration {
	@Bean
	public BasicDataSource dataSource() throws Exception{
		URI url = new URI("#{systemEnvironment['DATABASE_URL']}");
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("#{ 'jdbc:postgresql://' + @dbUrl.getHost() + ':' + @dbUrl.getPort() + @dbUrl.getPath() }");
		basicDataSource.setUsername("#{ @dbUrl.getUserInfo().split(':')[0] }");
		basicDataSource.setPassword("#{ @dbUrl.getUserInfo().split(':')[1] }");
		
		return basicDataSource;
	}
}
