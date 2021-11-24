package ru.ashcheulov.producers;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.AppleProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ApplePayProducer {

    @Produces
    @AppleProducer
    public PaymentMessage getMessage() {
        return new PaymentMessage("Apple pay");
    }
}
