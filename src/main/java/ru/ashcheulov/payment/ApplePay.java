package ru.ashcheulov.payment;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.Apple;
import ru.ashcheulov.qualifiers.AppleProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Apple
public class ApplePay implements IPaymentService {

    @Inject
    @AppleProducer
    PaymentMessage paymentMessage;

    @Override
    public String pay() {
        return paymentMessage.getMessage();
    }
}