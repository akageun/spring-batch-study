package kr.geun.o.hwp.batch.config;

import org.h2.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Database Setting
 *
 * @author akageun
 */
@Configuration
public class MainDatabaseConfiguration {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(Driver.load());
		dataSource.setUrl("jdbc:h2:./main;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
}
