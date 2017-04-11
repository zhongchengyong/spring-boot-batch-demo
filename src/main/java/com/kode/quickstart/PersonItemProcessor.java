package com.kode.quickstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * 实现ItemProcessor<input,output>实现类
 * Created by kodezhong on 2017/4/11.
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person item) throws Exception {
        final String firstName = item.getFirstName().toUpperCase();
        final String lastName = item.getLastName().toUpperCase();

        final Person transferPerson = new Person(firstName, lastName);
        logger.info("transfer " + item + "to " + transferPerson);
        return transferPerson;
    }
}
