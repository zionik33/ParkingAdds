package queues;

import java.util.Properties;

/**
 * Created by mcboman on 14/10/2016.
 */
public abstract class QueueMessenger {
    public abstract boolean sendMessage(Properties props, String message);
}
