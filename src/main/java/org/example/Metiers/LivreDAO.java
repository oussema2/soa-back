package org.example.Metiers;

import org.example.DAO.ConnectionSingleton;
import org.example.Entity.Livre;
import org.example.Entity.LivreWithCatLabel;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class LivreDAO  {


  
    public boolean addLivre(Livre book) throws SQLException {
        try{
        Connection con = ConnectionSingleton.getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO book (title, author,nombrePage, price , idCat ) VALUES (?,?,?,?,?);");

        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setInt(3, book.getPageNumber());
        preparedStatement.setFloat(4, book.getPrice());
            preparedStatement.setInt(5, book.getIdCat());
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

    public boolean deleteLivre(int id)  {
        System.out.println("test");
        System.out.println(id);
        try {
        Connection con = ConnectionSingleton.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM book WHERE id = "+id + ";");
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

    public ArrayList<LivreWithCatLabel> getAllLivres() {
        ArrayList<LivreWithCatLabel> bookList = new ArrayList();
        try{
            Connection conn = ConnectionSingleton.getConnection();
            String query = "SELECT b.* , c.label as catLabel , c.id as idCat FROM book b join categorie c on b.idCat = c.id ;";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                String author = rs.getString("author");
                String title = rs.getString("title");
                float price = rs.getFloat("price");
                int pageNumber = rs.getInt("nombrePage");
                int id = rs.getInt("id");
                int idCat = rs.getInt("idCat");
                String catLabel = rs.getString("catLabel");

                LivreWithCatLabel book = new LivreWithCatLabel(id,title,author,pageNumber,price , idCat ,catLabel );
                bookList.add(book);
                System.out.println(bookList);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return bookList;
    }

    public Livre getLivreById(int id) {
        ArrayList<Livre> bookList = new ArrayList();
        try{
            Connection conn = ConnectionSingleton.getConnection();
            String query = "SELECT b.* , c.label , c.id as idCat FROM book b join categorie c on b.idCat = c.id  where b.id  = "+id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                String author = rs.getString("author");
                String title = rs.getString("title");
                float price = rs.getFloat("price");
                int pageNumber = rs.getInt("nombrePage");
                int idbook = rs.getInt("id");
                int idCat = rs.getInt("idCat");

                Livre book = new Livre(idbook,title,author,pageNumber,price , idCat);
                bookList.add(book);
                return  book;
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<LivreWithCatLabel> getLivresByName(String name) {
        ArrayList<LivreWithCatLabel> bookList = new ArrayList();
        try{
            Connection conn = ConnectionSingleton.getConnection();
            String query = "SELECT b.* , c.label , c.id as idCat FROM book b join categorie c on b.idCat = c.id  where b.title like '%"+name+"%' ;";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                String author = rs.getString("author");
                String title = rs.getString("title");
                float price = rs.getFloat("price");
                int pageNumber = rs.getInt("nombrePage");
                int id = rs.getInt("id");
                int idCat = rs.getInt("idCat");
                String catLabel = rs.getString("label");

                LivreWithCatLabel book = new LivreWithCatLabel(id,title,author,pageNumber,price , idCat ,catLabel );
                bookList.add(book);
                System.out.println(bookList);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return bookList;

    }

    public boolean updateLivre(Livre book) {
        try{
            Connection con = ConnectionSingleton.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement("UPDATE  book SET title = ? , author = ?,nombrePage = ?, price =?, idCat = ? where id = ? ;");

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getPageNumber());
            preparedStatement.setFloat(4, book.getPrice());
            preparedStatement.setInt(5, book.getIdCat());
            preparedStatement.setInt(6, book.getId());
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
}
