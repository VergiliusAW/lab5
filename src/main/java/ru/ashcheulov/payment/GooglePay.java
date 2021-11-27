package ru.ashcheulov.payment;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.Google;
import ru.ashcheulov.qualifiers.GoogleProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Implementation for Google pay payment service
 * Для внедрения этой зависимости еобходимо использовать Qualifier @Google
 */
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
