package kr.geun.o.hwp.batch.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MULTI BASIC Configuration
 *
 * @author akageun
 */
@Configuration
public class MultiBasicTestConfiguration {
	private static final Logger LOG = LoggerFactory.getLogger(MultiBasicTestConfiguration.class);

	private static final String MULTI_BASIC_JOB_NM = "MULTI_BASIC_JOB";
	private static final String MULTI_BASIC_STEP_NM = "MULTI_BASIC_TASKLET_STEP";

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	/**
	 * MULTI_BASIC Job Configuration
	 *
	 * @return
	 */
	@Bean(name = MULTI_BASIC_JOB_NM)
	public Job multiBasicJob() {
		//@formatter:off
		return jobBuilderFactory
			.get(MULTI_BASIC_JOB_NM)
				.incrementer(new RunIdIncrementer())
					.start(multiBasicTaskletStep())
			.build();
		//@formatter:on
	}

	/**
	 * MULTI_BASIC Step Configuration
	 *
	 * @return
	 */
	@Bean(name = MULTI_BASIC_STEP_NM)
	public Step multiBasicTaskletStep() {
		//@formatter:off
		return stepBuilderFactory
			.get(MULTI_BASIC_STEP_NM)
				.tasklet((stepContribution, chunkContext) -> {
					LOG.info("Tasklet Multi Job Run!!");

					return RepeatStatus.FINISHED;
				})
			.build();
		//@formatter:on
	}
}
