package org.example;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Hello world!
 *
 */
@Path("/hello")
public class App 
{
   @GET
    @Path("/sayHi")
   public Response sayHi() {
       return Response.status(Response. Status. OK)
               .entity("Hi, world")
               .build();
   }
}
