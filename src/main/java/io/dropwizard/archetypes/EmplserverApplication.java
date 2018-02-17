package io.dropwizard.archetypes;
import java.util.EnumSet;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import io.dropwizard.Application;
import io.dropwizard.archetypes.resources.Employees;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class EmplserverApplication extends Application<EmplserverConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EmplserverApplication().run(args);
    }

    @Override
    public String getName() {
        return "Emplserver";
    }

    @Override
    public void initialize(final Bootstrap<EmplserverConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final EmplserverConfiguration configuration, final Environment environment) {

        environment.jersey().register(new Employees());
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }


}
