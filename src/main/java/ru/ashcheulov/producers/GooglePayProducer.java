package ru.ashcheulov.producers;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.GoogleProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * Продюсер для GooglePay
 */
@ApplicationScoped
public class GooglePayProducer {

    /**
     * TODO: Intellij Idea ругается на @Inject method cannot be annotated with 'javax.enterprise.inject.Produces'. Скорее всего является багом IDE
     *
     * @return Сообщение об оплате
     */
    @Produces
    @GoogleProducer
    public PaymentMessage getMessage() {
        return new PaymentMessage("Google pay");
    }
}
