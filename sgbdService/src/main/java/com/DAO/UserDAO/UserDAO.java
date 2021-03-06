package main.java.com.DAO.UserDAO;

import main.java.com.DAO.SGBDConnexion.AbstractDAO;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by Jocelyn on 13/01/2016.
 */
public class UserDAO extends AbstractDAO {

    //Random Object for generating token
    private Random random = new Random();
    //Caract�re autoris� pour le token
    private String characters = "abcdefghijklmnopqrstwxyz1234567489";
    //Request for user connection
    private final String CONNECT_USER = "SELECT id, login from utilisateur where login=? and password=?;";
    //Request for user connection
    private final String SET_USER_TOKEN = "INSERT INTO token VALUES(?,?);";
    //Request for user connection
    private final String IS_TOKEN_VALID = "SELECT * FROM token t WHERE t.token = ? AND t.id_user = (SELECT id FROM utilisateur WHERE login = ?)";
    //Request for check if token exist in base
    private final String TOKEN_EXIST = "SELECT token FROM token WHERE id_user = ?";

    /*
    Contructor
     */
    public UserDAO(){
    }

    /**
     * Fonction verifiant les logins/mdp en base
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    public String connexionUser(String login, String password) throws SQLException {
        int codeRetour = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(CONNECT_USER);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            //On a trouve un user dans la base avec les infos
            if(resultSet.next()) {
                String token = this.setUserToken(resultSet.getInt("id"));
                return token;
            }
            //Mauvaise combinaison login/mdp
            else{
                return "-1";
            }

        }
        //Probl�me d'acc�s bdd
        catch (SQLException e) {
            e.printStackTrace();
            return "-1";
        }
    }

    /**
     * Methode priv�e verifiant si un token existe en base
     * Sinon en creer un et l'ajoute en base
     * @param idUser
     * @return
     */
    private String setUserToken(int idUser){
        String token = generateToken(random.nextInt(64));
        String tokenExist = this.checkTokenExist(idUser);
        //Le token est inexistant
        if(tokenExist == null){
            try {
                PreparedStatement statement = connection.prepareStatement(SET_USER_TOKEN);
                statement.setInt(1, idUser);
                statement.setString(2, token);
                statement.executeUpdate();
            }
            //Erreur lors de l'ajout du token
            catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            return token;
        }
        else{
            return tokenExist;
        }
    }

    /**
     * Fonction generant le token
     * @param length
     * @return
     */
    private String generateToken(int length){
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

    /**
     * Methode priv�e v�rifiant si un token
     * Existe d�j� en base pour un utilisateur
     * @param idUser
     * @return le token si existant, sinon null
     */
    private String checkTokenExist(int idUser){
        String token = null;
        try {
            PreparedStatement statement = connection.prepareStatement(TOKEN_EXIST);
            statement.setInt(1, idUser);
            ResultSet resultSet = statement.executeQuery();

            //Le token est existant en base on le renvois
            if(resultSet.next()) {
                token = resultSet.getString("token");
            }
        }
        //Erreur lors de l'ajout du token
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * Methode verifiant si le token est valide pour
     * l'utilisateur (pas de verification de poste).
     * @param login
     * @return
     */
    public boolean isValideToken(String login, String token){
        try{
            PreparedStatement statement = connection.prepareStatement(IS_TOKEN_VALID);
            statement.setString(1, token);
            statement.setString(2, login);
            ResultSet resultSet = statement.executeQuery();

            //Le token est existant en base, le token est donc valide
            if(resultSet.next()) {
                return true;
            }
            //pas de token trouv�, donc token invalide
            else{
                return false;
            }

        }
        //Probl�me d'acc�s bdd
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
