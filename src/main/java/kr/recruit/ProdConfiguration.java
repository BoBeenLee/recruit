package kr.recruit;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfiguration {
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();

		try {
			String username = "developer";
			String password = "developer";
			String url = "jdbc:mariadb://localhost:3306/recruit";
			String getenv = System.getenv("DATABASE_URL");
			String dbProperty = null; // System.getProperty(getenv);
			
			if(getenv != null)
				dbProperty = System.getProperty(getenv);
			if (dbProperty != null) {
				URI dbUri = new URI(dbProperty);
				
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
