import rest.EmailResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mcboman on 08/10/2016.
 */

@ApplicationPath("/resource")
public class App extends Application {

    private final Set<Class<?>> classes;

    public App() {

        HashSet<Class<?>> c = new HashSet<Class<?>>();
        c.add(EmailResource.class);
        classes = Collections.unmodifiableSet(c);

    }

    public Set<Class<?>> getClasses() {
        return classes;
    }
}
