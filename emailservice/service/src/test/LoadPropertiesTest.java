import org.junit.Assert;
import org.junit.Test;
import queues.QueueMessenger;
import queues.UserinfoQueue;
import rest.EmailResource;
import util.PropertyValues;
import util.QueueProperties;

import java.util.Properties;

/**
 * Created by mcboman on 13/10/2016.
 */
public class LoadPropertiesTest {

    @Test
    public void testEmailLoadProperties(){
        try{
            EmailResource emailRe = new EmailResource();
        }catch (Exception e){
            Assert.assertFalse("Failed to load properties.", true);
        }
    }

    @Test
    public void QueuePropertiesTest(){
        PropertyValues utilPropsLoader = new QueueProperties();
        try{
            Properties props = utilPropsLoader.getProperties("rabbitmq.properties");
            Assert.assertNotNull(props);
        }catch (Exception e){
            Assert.assertFalse("Error loading properties.", true);
        }
    }

    @Test
    public void SendMessageTest(){
        try{
            PropertyValues utilPropsLoader = new QueueProperties();
            Properties props = utilPropsLoader.getProperties("rabbitmq.properties");
            QueueMessenger messenger = new UserinfoQueue();
            boolean status = messenger.sendMessage(props, "test");
            Assert.assertTrue("Message integration test", status);
        }catch (Exception e){
            Assert.assertFalse("Failed to send message.", true);
        }
    }

}
