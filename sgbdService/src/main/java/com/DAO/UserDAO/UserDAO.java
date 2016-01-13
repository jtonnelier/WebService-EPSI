package main.java.com.DAO.UserDAO;

import main.java.com.DAO.SGBDConnexion.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jocelyn on 13/01/2016.
 */
public class UserDAO extends AbstractDAO {

    public final String CONNECT_USER = "SELECT login from user where login=? and mdp=?;";
    public UserDAO(){
    }

    /**
     * Fonction verifiant les logins/mdp en base
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    public int connexionUser(String login, String password) throws SQLException {
        int codeRetour = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(CONNECT_USER);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            //On a trouve un user dans la base avec les infos
            if(resultSet.next()) {
                return 1;
            }
            //Mauvaise combinaison login/mdp
            else{
                return 0;
            }

        }
        //Problème d'accès bdd
        catch (SQLException e) {
            return -1;
        }
    }
}
