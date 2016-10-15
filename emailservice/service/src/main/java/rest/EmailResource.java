package rest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.log4j.Logger;
import queues.QueueMessenger;
import queues.UserinfoQueue;
import util.PropertyValues;
import util.QueueProperties;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Properties;

/**
 * Created by mcboman on 08/10/2016.
 * @author Bo Stokholm
 */
@Path("/email")
public class EmailResource {
    private final static String QUEUE = "rabbitmq.properties";
    private final static Logger logger = Logger.getLogger(EmailResource.class);


    private Properties props;
    private String userInfoQueue;
    private String exceptionQueue;

    public EmailResource(){
        try{
            PropertyValues propsGetter = new QueueProperties();
            props = propsGetter.getProperties(QUEUE);
            if(null == props)
                throw new Exception("EmailResource error. Loading properties for file: " + QUEUE + " failed.");
        }catch (Exception e){
            logger.error("Loading properties in class: EmailResource gave:\n" + e);
        }
    }

    /*
    * @param String RabbitMQ properties filename
    * */
    public EmailResource(String queueFilename){
        try{
            PropertyValues propsGetter = new QueueProperties();
            props = propsGetter.getProperties(QUEUE);
            if(null == props)
                throw new Exception("EmailResource error. Loading properties for file: " + QUEUE + " failed.");
        }catch (Exception e){
            logger.error("Loading properties in class: EmailResource gave:\n" + e);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMail(@QueryParam("email") @NotNull @Size(min=4)String email,
                             @QueryParam("longitude") @NotNull @Size(min=3, max=6) String longitude,
                             @QueryParam("latitude") @NotNull @Size(min=3, max=6) String latitude) throws ValidationException{

        boolean status = false;
        try{
            QueueMessenger messenger = new UserinfoQueue();
            String message = email + "," + longitude + "," + latitude;
            status = messenger.sendMessage(props, message);

            if(!status)
                throw new Exception("Message not send from EmailResource class. Method sendMail.");
        }catch (Exception e){
            logger.error("EmailService class doing sendMail gave: \n" + e + "\n" + "On host: " + props.getProperty("HOST"));
            return Response.serverError().build();
        }

        return Response.ok("Message delivered.").build();
    }

    @GET
    @Produces("application/json")
    public String getAll(){
        return "hello";
    }
}
