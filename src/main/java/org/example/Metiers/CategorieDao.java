package org.example.Metiers;

import org.example.DAO.ConnectionSingleton;
import org.example.Entity.Catgorie;
import org.example.Entity.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategorieDao {


    public boolean addCategorie(Catgorie cat) {
        try{
            Connection con = ConnectionSingleton.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO categorie (label , booknumber) VALUES (?,?);");

            preparedStatement.setString(1, cat.getLabel());
            preparedStatement.setInt(2, cat.getBooksNumber());


            int row = preparedStatement.executeUpdate();
            if(row > 0) {
                return true;
            }
            System.out.println(row);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return false;
    }

    public boolean updateCategorie(Catgorie cat) {
        try{
            Connection con = ConnectionSingleton.getConnection();
            System.out.println(cat.toString());
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE  categorie SET label = ? , booknumber = ?  where id = ?;");

            preparedStatement.setString(1, cat.getLabel());
            preparedStatement.setInt(2, cat.getBooksNumber());

            preparedStatement.setInt(3, cat.getId());

            int row = preparedStatement.executeUpdate();
            if(row > 0) {
                return true;
            }
            System.out.println(row);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return false;
    }

    public boolean deleteCategorie(int id)  {

        try {
            Connection con = ConnectionSingleton.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM categorie WHERE id = "+id + ";");
            int row = preparedStatement.executeUpdate();
            System.out.println("Result row ====>" + row);
            if(row > 0) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }
    public ArrayList<Catgorie> getAllCategories() {
        ArrayList<Catgorie> categorieList = new ArrayList();
        try{
            Connection conn = ConnectionSingleton.getConnection();
            String query = "SELECT * FROM categorie ;";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {

                int id = rs.getInt("id");
                String label = rs.getString("label");
                int booksNumber = rs.getInt("booknumber");
                Catgorie cat = new Catgorie(id,label , booksNumber);
                categorieList.add(cat);
                System.out.println(categorieList);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return categorieList;
    }

    public Catgorie getCategorieById(int id) {
        ArrayList<Catgorie> categorieList = new ArrayList();
        try{
            Connection conn = ConnectionSingleton.getConnection();
            String query = "SELECT * from  categorie  where id  = "+id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                int idcar = rs.getInt("id");
                String label = rs.getString("label");
                int booksNumber = rs.getInt("booknumber");
                Catgorie cat = new Catgorie(idcar,label , booksNumber);
                categorieList.add(cat);
                System.out.println(categorieList);


                return  cat;
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
