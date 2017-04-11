package com.kode.quickstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Listener
 * Created by kodezhong on 2017/4/11.
 */
@Component
public class JobCompletionListener extends JobExecutionListenerSupport {
    private static final Logger logger = LoggerFactory.getLogger(JobCompletionListener.class);

    private JdbcTemplate jdbcTemplate;

    public JobCompletionListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("batch task complete,it is time to verify result");

            List<Person> results = jdbcTemplate.query("SELECT first_name, last_name FROM person",
                    (rs, row) -> new Person(rs.getString(1), rs.getString(2)));
            results.forEach(person -> logger.info(person.toString()));
        }
    }
}
