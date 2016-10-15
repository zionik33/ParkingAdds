package queues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * Created by mcboman on 14/10/2016.
 */
public class UserinfoQueue extends QueueMessenger {

    private final static Logger logger = Logger.getLogger(UserinfoQueue.class);

    private String userInfoQueue;

    @Override
    public boolean sendMessage(Properties props, String message) {
        boolean status = false;
        userInfoQueue = props.getProperty("USERINFO_QUEUE");
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(props.getProperty("HOST"));
        connectionFactory.setUsername(props.getProperty("USERNAME"));
        connectionFactory.setPassword(props.getProperty("PASSWORD"));
        if(message.length() <= 2)
            return status;
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(props.getProperty("USERINFO_EXCHANGE_NAME"), props.getProperty("USERINFO_EXCHANGE_TYPE"));
            channel.basicPublish("", userInfoQueue, null, message.getBytes());
            logger.info("[X] Sent '" + message + "' to queue: " + userInfoQueue );
            channel.close();
            connection.close();
            status = true;
        }catch (Exception e){
            logger.error("UserinfoQueue class doing sendMessage gave: \n" + e + "\n" + "On host: " + props.getProperty("HOST"));
        }
        return status;
    }
}
