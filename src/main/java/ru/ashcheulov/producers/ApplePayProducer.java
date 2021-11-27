package ru.ashcheulov.producers;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.AppleProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * Продюсер для ApplePay
 */
@ApplicationScoped
public class ApplePayProducer {

    /**
     * TODO: Intellij Idea ругается на @Inject method cannot be annotated with 'javax.enterprise.inject.Produces'. Скорее всего является багом IDE
     *
     * @return Сообщение об оплате
     */
    @Produces
    @AppleProducer
    public PaymentMessage getMessage() {
        return new PaymentMessage("Apple pay");
    }
}
