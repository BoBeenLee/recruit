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
			String dbUrl = "jdbc:mariadb://localhost:3306/recruit";
			String DATABASE_URL = System.getenv("DATABASE_URL");
		
			if(DATABASE_URL == null)
				DATABASE_URL = "postgres://obmhdagdcusujf:NXUAjaRQxhdjx6EY3o19-E-V0D@ec2-174-129-26-115.compute-1.amazonaws.com:5432/dbda4maar31q9a";
			if (DATABASE_URL != null) {
				URI dbUri = new URI(DATABASE_URL);
				
				username = dbUri.getUserInfo().split(":")[0];
				password = dbUri.getUserInfo().split(":")[1];
				dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
			}
			
			basicDataSource.setDriverClassName("org.postgresql.Driver");
			basicDataSource.setUrl(dbUrl);
			basicDataSource.setUsername(username);
			basicDataSource.setPassword(password);
			basicDataSource.setInitialSize(1);
		} catch (URISyntaxException e) {
			// Deal with errors here.
		}
		
		return basicDataSource;
	}
}
