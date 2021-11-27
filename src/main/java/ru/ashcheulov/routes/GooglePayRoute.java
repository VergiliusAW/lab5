package ru.ashcheulov.routes;

import ru.ashcheulov.payment.IPaymentService;
import ru.ashcheulov.qualifiers.Google;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class GooglePayRoute {

    @Inject
    @Google
    IPaymentService paymentService;

    /**
     * Оплатить с помощью GooglePay
     *
     * @return сообщние об облате
     */
    @GET
    @Path("google-pay")
    @Produces(MediaType.TEXT_PLAIN)
    public String pay() {
        return paymentService.pay();
    }
}
