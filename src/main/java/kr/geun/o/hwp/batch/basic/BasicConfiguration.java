package kr.geun.o.hwp.batch.basic;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Basic Configuration
 *
 * @author akageun
 */
@Configuration
public class BasicConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job basicJob() {
		//@formatter:off
		return jobBuilderFactory
			.get("basicJob")
				.incrementer(new RunIdIncrementer())
					.start(basicTaskletStep())
			.build();
		//@formatter:on
	}

	@Bean
	public Step basicTaskletStep() {
		//@formatter:off
		return stepBuilderFactory
			.get("basicTaskletStep")
				.tasklet((stepContribution, chunkContext) -> {
					System.out.println("test");
					return null;
				})
			.build();
		//@formatter:on
	}
}
