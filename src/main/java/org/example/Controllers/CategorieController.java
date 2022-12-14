package org.example.Controllers;

import org.example.Entity.Catgorie;
import org.example.Entity.Livre;
import org.example.Metiers.CategorieDao;
import org.example.Metiers.LivreDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/cat")
public class CategorieController {

    private static CategorieDao catDao =new CategorieDao();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addCategorie")
    public static Response add(Catgorie cat) throws URISyntaxException, SQLException {
        boolean res =  catDao.addCategorie(cat);

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
    @Path("/updateCategorie")
    public static Response update(Catgorie cat) throws URISyntaxException, SQLException {
        boolean res =  catDao.updateCategorie(cat);

        if(res) {
            return Response.status(Response. Status.OK)
                    .entity("UPDATED")
                    .build();
        }
        return Response.status(Response. Status. OK)
                .entity("ERROR")
                .build();

    }

    @DELETE
    @Path("/deleteCategorie/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategorie(@PathParam("id") int id){
        System.out.println("running");
        boolean res = catDao.deleteCategorie(id);
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
        ArrayList<Catgorie> data = catDao.getAllCategories();
        return Response.status(Response.Status.OK)
                .entity(data)
                .build();
    }

    @GET
    @Path("/getByID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks(@PathParam("id") int id) {
        Catgorie cat = catDao.getCategorieById(id);
        if(cat != null){
            return Response.status(Response.Status.OK)
                    .entity(cat)
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity("No Book found")
                .build();
    }

}
