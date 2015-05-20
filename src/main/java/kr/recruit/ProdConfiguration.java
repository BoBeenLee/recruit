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
	public BasicDataSource dataSource() {
		URI dbUri;
		BasicDataSource basicDataSource = new BasicDataSource();
		
		try {
			String username = "developer";
			String password = "developer";
			String url = "jdbc:mariadb://localhost:3306/recruit";
			String dbProperty = System.getProperty("database.url");
			if (dbProperty != null) {
				dbUri = new URI(dbProperty);

				username = dbUri.getUserInfo().split(":")[0];
				password = dbUri.getUserInfo().split(":")[1];
				url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
			}
			basicDataSource.setUrl(url);
			basicDataSource.setUsername(username);
			basicDataSource.setPassword(password);
		} catch (URISyntaxException e) {
			// Deal with errors here.
		}
		return basicDataSource;
	}
}
