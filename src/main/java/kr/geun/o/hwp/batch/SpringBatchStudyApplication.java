package kr.geun.o.hwp.batch;

import org.h2.Driver;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Entry Class
 *
 * @author akageun
 */
@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchStudyApplication {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(Driver.load());
		dataSource.setUrl("jdbc:h2:./test;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchStudyApplication.class, args);
	}
}
