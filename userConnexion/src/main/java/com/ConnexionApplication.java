package main.java.com;

/**
 * Created by Jocelyn on 02/12/2015.
 */

import java.util.Collections;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("")
public class ConnexionApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.emptySet();
    }
}