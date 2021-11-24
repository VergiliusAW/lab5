package ru.ashcheulov.routes;

import ru.ashcheulov.payment.IPaymentService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class MyAwesomePayRoute {

    @Inject
    IPaymentService paymentService;

    @GET
    @Path("my-awesome-pay")
    @Produces(MediaType.TEXT_PLAIN)
    public String pay() {
        return paymentService.pay();
    }
}
