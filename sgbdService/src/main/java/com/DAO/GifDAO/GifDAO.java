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

    //Requete recuperation des gifs d'un utilisateur
    private final String GET_GIF_USER = "SELECT lien FROM gif WHERE id_user = (SELECT id FROM utilisateur WHERE login = ?);";
    //Requete d'ajout de d'un gif pour un utilisateur
    private final String ADD_GIF_USER = "INSERT INTO gif VALUES ((SELECT id FROM utilisateur WHERE login = ?),?,?,?);";
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

    /**
     * Ajout d'un gif en base pour un utilisateur
     * @param login
     * @return
     */
    public int addGifUser(String login, String label, String url){
        int gifAdded = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(ADD_GIF_USER);
            statement.setString(1, login);
            statement.setString(2, label);
            statement.setString(3, url);
            statement.setInt(4, 1); //Only Giphy for the moment
            gifAdded = statement.executeUpdate();
        }
        //Problème d'accès bdd
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gifAdded;
    }
}
