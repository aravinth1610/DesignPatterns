package com.Observer.ecom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotifier {
    private final String notifierId;

    public EmailNotifier() {
        this.notifierId = "Email-" + System.currentTimeMillis();
    }

    @EventListener
    public void onProductUpdate(ProductUpdateEvent event) {
        System.out.println("Email Notifier [" + notifierId + "]: Sending email for product " +
                           event.getProduct().getName() + ": " + event.getChangesDesc());
    }
}