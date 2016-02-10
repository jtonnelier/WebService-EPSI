package main.java.com.DAO.GifDAO;

import main.java.com.DAO.SGBDConnexion.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Jocelyn on 10/02/2016.
 */
public class GifDAO extends AbstractDAO {

    //requete recuperation des gifs d'un utilisateur
    private final String GET_GIF_USER = "SELECT lien FROM gif WHERE id_user = (SELECT id FROM utilisateur WHERE login = ?);";
    /*
   Contructor
    */
    public GifDAO(){
    }

    /**
     * Recuperation des gifs en base d'un utilisateur
     * a partir de son login
     * @param login
     * @return
     */
    public ArrayList<String> getGifUser(String login){
        ArrayList<String> gifsList = new ArrayList<String>();
        try{
            PreparedStatement statement = connection.prepareStatement(GET_GIF_USER);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            //On recupere tout les gifs en base
            while(resultSet.next()) {
                gifsList.add(resultSet.getString("lien"));
            }
        }
        //Problème d'accès bdd
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gifsList;
    }

}
