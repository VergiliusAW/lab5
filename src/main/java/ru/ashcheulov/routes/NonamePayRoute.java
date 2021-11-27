package ru.ashcheulov.routes;

import ru.ashcheulov.enums.PayServiceType;
import ru.ashcheulov.payment.ApplePay;
import ru.ashcheulov.payment.GooglePay;
import ru.ashcheulov.payment.IPaymentService;
import ru.ashcheulov.payment.MyAwesomePay;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class NonamePayRoute {

    @Inject
    @Any
    Instance<IPaymentService> paymentServices;

    /**
     * Предоставляет список доступных сервисов для оплаты (просмотр всех реализаций бина IPaymentService)
     * @return сообщение включающее список доступные сервисы
     */
    @GET
    @Path("noname-pay")
    @Produces(MediaType.TEXT_PLAIN)
    public String pay() {
        var responseBuilder = new StringBuilder();
        responseBuilder.append("Available payment services:").append("\n");
        for (IPaymentService paymentService : paymentServices) {
            responseBuilder.append(paymentService.pay()).append("\n");
        }
        return responseBuilder.toString();
    }

    /**
     * Оплатить с помощью сервиса определённого типа
     * @param type тип сервиса для оплаты
     * @return сообщение об оплате с помощью соответствующего сервиса
     */
    @GET
    @Path("noname-pay/{type}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pay(@PathParam("type") PayServiceType type) {
        switch (type) {
            case APPLE:
                return paymentServices.select(ApplePay.class).get().pay();
            case GOOGLE:
                return paymentServices.select(GooglePay.class).get().pay();
            case AWESOME:
                return paymentServices.select(MyAwesomePay.class).get().pay();
            default:
                return "error";
        }
    }
}
