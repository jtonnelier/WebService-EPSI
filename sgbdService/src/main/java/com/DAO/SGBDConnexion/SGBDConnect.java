package main.java.com.DAO.SGBDConnexion;

import java.sql.*;
/**
 * Created by Jocelyn on 04/12/2015.
 */
public class SGBDConnect {

    /**
     * URL de connection
     */
    private static String url = "jdbc:mysql://localhost:3306/webservice";
    /**
     * Nom du user
     */
    private static String user = "root";
    /**
     * Mot de passe du user
     */
    private static String passwd = "";
    /**
     * Objet Connection
     */
    private static Connection connect;

    /**
     * Méthode qui va nous retourner notre instance
     * et la créer si elle n'existe pas...
     * @return
     */

    public static Connection getInstance(){
        if(connect == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(url, user, passwd);
                //getInformationConnectivity();
            } catch (SQLException e) {
            } catch (ClassNotFoundException e) {
            }
        }
        return connect;
    }
}
