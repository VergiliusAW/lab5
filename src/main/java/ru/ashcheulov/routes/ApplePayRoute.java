package ru.ashcheulov.routes;

import ru.ashcheulov.payment.IPaymentService;
import ru.ashcheulov.qualifiers.Apple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class ApplePayRoute {

    @Inject
    @Apple
    IPaymentService paymentService;

    /**
     * Оплатить с помощью ApplePay
     *
     * @return сообщние об облате
     */
    @GET
    @Path("apple-pay")
    @Produces(MediaType.TEXT_PLAIN)
    public String pay() {
        return paymentService.pay();
    }
}
