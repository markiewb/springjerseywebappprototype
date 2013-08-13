package com.sample.rest;

import com.sample.service.MyService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/coin")
public class RestService {
 
    @Autowired
    MyService delegate;

    /**
     * http://localhost:8080/springjerseywebapp/rest/coin/greet
     */
    @GET
    @Path("/hello")
    public Response greet() {
        String result = delegate.greet();
        return Response.status(200).entity(result).build();
    }

    /**
     * http://localhost:8080/springjerseywebapp/rest/coin/info/42
     */
    @GET
    @Path("/info/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCoinText(@PathParam("id") int number) {
        return "Coin: " + number;
    }

    /**
     * http://localhost:8080/springjerseywebapp/rest/coin/info/42/html
     */
    @GET
    @Path("/info/{id}/html")
    @Produces(MediaType.TEXT_HTML)
    public String getCoinHTML(@PathParam("id") int number) {
        return "<html><body><b>Coin: </b>" + number + "</body></html>";
    }

}
