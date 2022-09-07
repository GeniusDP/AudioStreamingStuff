package com.kpi.zaranik.template;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 5000)
    public void printLogs(){
        System.out.println("This is log. Time is: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy :: hh:mm:ss")));
    }

}
