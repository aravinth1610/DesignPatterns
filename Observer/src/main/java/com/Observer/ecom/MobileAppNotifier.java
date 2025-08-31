package com.Observer.ecom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MobileAppNotifier {
    private final String clientId;

    public MobileAppNotifier() {
        this.clientId = "Mobile-" + System.currentTimeMillis();
    }

    @EventListener
    public void onProductUpdate(ProductUpdateEvent event) {
        System.out.println("Mobile App [" + clientId + "]: Product update - " +
                           event.getProduct().getName() + ": " + event.getChangesDesc());
    }
}
