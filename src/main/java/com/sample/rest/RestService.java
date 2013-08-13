package com.sample.rest;

import com.sample.service.MyService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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

    @GET
    @Path("/json")
    public JSONObject json() {
        JSONObject myObject = createJsonObj();
        try {
            myObject.put("inner", createJsonObj());
        } catch (JSONException ex) {
            Logger.getLogger(RestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myObject;

//        String result = delegate.greet();
//        return Response.status(200).entity(result).build();
    }

    private JSONObject createJsonObj() {
//        JSONObject myObject = new JSONObject();
        JSONObject myObject = new JSONObject();
        try {
            myObject.put("name", "Agamemnon").put("age", 32);
        } catch (JSONException ex) {
//     LOGGER.log(Level.SEVERE, "Error ...", ex);
        }
        return myObject;
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
