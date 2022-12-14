package org.example.Controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import jdk.net.SocketFlow;
import lombok.experimental.Delegate;
import org.example.Entity.Livre;
import org.example.Entity.LivreWithCatLabel;
import org.example.Metiers.LivreDAO;

@Path("/livre")
public class LivreController {
    private static LivreDAO livreDAO =new LivreDAO();



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addBook")
    public static Response add(Livre livre) throws URISyntaxException, SQLException {
     boolean res =  livreDAO.addLivre(livre);

     if(res) {
         return Response.status(Response. Status.OK)
                 .entity("ADDED")
                 .build();
     }
        return Response.status(Response. Status. OK)
                .entity("ERROR")
                .build();

    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateBook")
    public static Response updateBook(Livre livre) throws URISyntaxException, SQLException {
        boolean res =  livreDAO.updateLivre(livre);

        if(res) {
            return Response.status(Response. Status.OK)
                    .entity("ADDED")
                    .build();
        }
        return Response.status(Response. Status. OK)
                .entity("ERROR")
                .build();

    }

    @DELETE
    @Path("/deleteBook/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") int id){
        System.out.println("running");
        boolean res = livreDAO.deleteLivre(id);
        if(res){
            return Response.status(Response. Status. OK)
                    .entity("DELETED")
                    .build();
        }
      return  Response.status(Response.Status.OK)
                .entity("NOT DELETED")
                .build();

    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        ArrayList<LivreWithCatLabel> data = livreDAO.getAllLivres();
        return Response.status(Response.Status.OK)
                .entity(data)
                .build();
    }

    @GET
    @Path("/getByID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks(@PathParam("id") int id) {
      Livre livre = livreDAO.getLivreById(id);
      if(livre != null){
          return Response.status(Response.Status.OK)
                  .entity(livre)
                  .build();
      }
        return Response.status(Response.Status.OK)
                .entity("No Book found")
                .build();
    }

    @GET
    @Path("/getByName/{pattern}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks(@PathParam("pattern") String pattern) {
        ArrayList<LivreWithCatLabel> data = livreDAO.getLivresByName(pattern);
        return Response.status(Response.Status.OK)
                .entity(data)
                .build();
    }


}
