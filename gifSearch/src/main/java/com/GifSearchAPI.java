package main.java.com;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Jocelyn on 13/01/2016.
 */
@ApplicationPath("")
public class GifSearchAPI extends Application {
    public Set<Class<?>> getClasses() {
        return Collections.emptySet();
    }
}
