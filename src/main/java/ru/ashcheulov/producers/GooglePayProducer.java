package ru.ashcheulov.producers;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.GoogleProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class GooglePayProducer {

    @Produces
    @GoogleProducer
    public PaymentMessage getMessage() {
        return new PaymentMessage("Google pay");
    }
}
