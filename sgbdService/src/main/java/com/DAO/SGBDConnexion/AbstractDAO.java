package main.java.com.DAO.SGBDConnexion;

import java.sql.Connection;

/**
 * Created by Jocelyn on 13/01/2016.
 */
public abstract class AbstractDAO {
    public Connection connection = SGBDConnect.getInstance();
}
