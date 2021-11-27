package ru.ashcheulov.producers;

import ru.ashcheulov.commons.PaymentMessage;
import ru.ashcheulov.qualifiers.AwesomeProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * Продюсер для MyAwesomePay
 */
@ApplicationScoped
public class MyAwesomePayProducer {

    /**
     * TODO: Intellij Idea ругается на @Inject method cannot be annotated with 'javax.enterprise.inject.Produces'. Скорее всего является багом IDE
     *
     * @return Сообщение об оплате
     */
    @Produces
    @AwesomeProducer
    public PaymentMessage getMessage() {
        return new PaymentMessage("My Awesome pay");
    }
}
