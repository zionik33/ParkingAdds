package util;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mcboman on 13/10/2016.
 */
public class QueueProperties extends PropertyValues {

    private final static Logger logger = Logger.getLogger(QueueProperties.class);

    @Override
    public Properties getProperties(String filename) throws Exception {
        InputStream inputStream;
        Properties prop = new Properties();
        try{
            inputStream = getClass().getClassLoader().getResourceAsStream(filename);

            if(inputStream != null)
                prop.load(inputStream);
            else
                throw new FileNotFoundException("Property file: " + filename + " couldn't be found.");
            inputStream.close();
        }catch (Exception e) {
            logger.error("Queue Properties failed, giving: \n" +e);
            throw new Exception(e);
        }
        return prop;
    }
}
