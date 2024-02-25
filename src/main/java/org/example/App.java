package org.example;

import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    static Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static ResourceBundle bundle=ResourceBundle.getBundle("application");
    public static void main( String[] args )
    {
        Integer[] arr={34,5,45,2,34,23,56,54,67,65,4,56,7,65,44,56};
        try{
            assert arr[0]>=10:"Insufficient value";
            logger.info(bundle.getString("log.info"));
        }
        catch (AssertionError as){
            logger.severe(bundle.getString("log.assert.error"));
        }
    }
}
