package com.mai.physical.events;

import com.mai.physical.services.PairBindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PairBindingEventListener {
    @Autowired
    private PairBindingService pairBindingService;

    @EventListener
    public void handlePairBindingEventCreation(PairBindingEvent event) {
        System.out.println("User registered: " + event.toString());
        event.getBindings().parallelStream().forEach(b -> pairBindingService.createBinding(b));


        // Additional logic can be added here, such as sending confirmation emails
    }
}


