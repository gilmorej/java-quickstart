package com.gilmore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AfterStartupRunner {

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        log.info("Application is ready.");
    }

}
