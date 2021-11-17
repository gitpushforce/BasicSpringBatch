package com.example.batch1.step;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class Step1Reader implements ItemReader<String> {

    private Iterator<String> iterator;

    @BeforeStep
    public void beforeStepForReader(StepExecution stepExecution) throws Exception {
        List<String> idList = new ArrayList<>();
        idList.add("3");
        idList.add("4");
        iterator = idList.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}
