package endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.JenaWrapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Path("/restrictions")
public class Restrictions {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRestrictions() throws IOException {
        List<String> restrictions = JenaWrapper.getAllRestrictions();

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(out, restrictions);

        final byte[] data = out.toByteArray();

        String json = new String(data);
        System.out.println(new String(data));

        return json;
    }
}
