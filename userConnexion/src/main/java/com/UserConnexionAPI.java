package main.java.com;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

/**
 * Classe Utilitaire pour Service Rest
 */
@ApplicationPath("")
public class UserConnexionAPI extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.emptySet();
    }
}