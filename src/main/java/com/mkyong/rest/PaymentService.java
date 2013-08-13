package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mkyong.transaction.TransactionBo;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/payment")
public class PaymentService {

    @Autowired
    TransactionBo transactionBo;

    /**
     * http://localhost:8080/springjerseywebapp/rest/payment/mkyong
     */
    @GET
    @Path("/mkyong")
    public Response savePayment() {

        String result = transactionBo.save();

        return Response.status(200).entity(result).build();

    }

    /**
     * http://localhost:8080/springjerseywebapp/rest/payment/coin/42
     */
    @GET
    @Path("/coin/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCoinText(@PathParam("id") int number) {
        return "Coin: " + number;
    }

    /**
     * http://localhost:8080/springjerseywebapp/rest/payment/coin/42/html
     */
    @GET
    @Path("/coin/{id}/html")
    @Produces(MediaType.TEXT_HTML)
    public String getCoinHTML(@PathParam("id") int number) {
        return "<html><body><b>Coin: </b>" + number + "</body></html>";
    }

}
