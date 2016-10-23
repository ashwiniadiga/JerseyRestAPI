package main.com.rest.api;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ashwad01 on 10/21/2016.
 */
@Path("/")
public class FirstRestApi {
    @POST
    @Path("/firstService")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response firstREST(InputStream incomingData) {
        StringBuilder strBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                strBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received: " + strBuilder.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(strBuilder.toString()).build();
    }

    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyRESTService(InputStream incomingData) {
        String result = "First RESTService Successfully started..";

        // return HTTP response 200 in case of success
        return Response.status(200).entity(result).build();
    }
}
