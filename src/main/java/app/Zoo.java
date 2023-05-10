package app;

import java.io.InputStream;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/zoo")
public class Zoo {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getZoo() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("zoo.xml")) {
            if (inputStream == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(inputStream).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
