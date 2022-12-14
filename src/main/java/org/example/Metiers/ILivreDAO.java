package org.example.Metiers;


import org.example.Entity.Livre;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ILivreDAO {

    public boolean addLivre(Livre l) throws SQLException;
    public boolean deleteLivre(int id);
    public ArrayList<Livre> getAllLivres();
    public Livre getLivreById();
    public ArrayList<Livre> getLivresByName();
    public void updateLivre(Livre l);

}
