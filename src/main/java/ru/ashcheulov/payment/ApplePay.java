package ru.ashcheulov.payment;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.Apple;
import ru.ashcheulov.qualifiers.AppleProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Implementation for Apple pay payment service
 * Для внедрения этой зависимости еобходимо использовать Qualifier @Apple
 */
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