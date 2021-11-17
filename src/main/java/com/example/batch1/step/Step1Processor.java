package com.example.batch1.step;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Step1Processor implements ItemProcessor<String, String> {
    @Override
    public String process(String s) throws Exception {
        System.out.println("processor: " + s);
        return "processor end";
    }
}
