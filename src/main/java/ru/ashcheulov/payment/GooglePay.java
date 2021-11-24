package ru.ashcheulov.payment;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.Google;
import ru.ashcheulov.qualifiers.GoogleProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Google
public class GooglePay implements IPaymentService {

    @Inject
    @GoogleProducer
    PaymentMessage paymentMessage;

    @Override
    public String pay() {
        return paymentMessage.getMessage();
    }
}
