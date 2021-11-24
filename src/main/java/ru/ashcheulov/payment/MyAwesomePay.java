package ru.ashcheulov.payment;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.AwesomeProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@ApplicationScoped
@Default
public class MyAwesomePay implements IPaymentService {

    @Inject
    @AwesomeProducer
    PaymentMessage paymentMessage;

    @Override
    public String pay() {
        return paymentMessage.getMessage();
    }
}
