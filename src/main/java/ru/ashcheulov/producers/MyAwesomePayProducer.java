package ru.ashcheulov.producers;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.AwesomeProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class MyAwesomePayProducer {

    @Produces
    @AwesomeProducer
    public PaymentMessage getMessage() {
        return new PaymentMessage("My Awesome pay");
    }
}
