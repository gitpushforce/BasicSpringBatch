package com.example.batch1.step;

import org.springframework.stereotype.Component;
import org.springframework.batch.item.ItemWriter;

import java.io.File;
import java.util.List;

@Component
public class Step1Writer implements ItemWriter<String> {


    @Override
    public void write(List<? extends String> list) throws Exception {
        File file = new File("./batch1test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        list.forEach(t -> {
            System.out.println("writer ok");
            System.out.println("aaa: " + t);
        });
    }
}
