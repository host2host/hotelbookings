package HotelBookings;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.MavenInvocationException;

import java.io.File;
import java.util.Collections;

public class HotelBookings_main {
    public static void main(String[] args) {

        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "pom.xml" ));
        request.setGoals( Collections.singletonList( "install" ));
        DefaultInvoker invoker = new DefaultInvoker();
       invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
        try {
           invoker.execute( request );
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        }
    }
}