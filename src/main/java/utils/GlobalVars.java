package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Integer.parseInt;


public class GlobalVars {
    private static String getConfigProperties(String key){
        String returnVal = null;

        try{
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");

            properties.load(file);
            returnVal = properties.getProperty(key).trim();
        }
        catch (IOException x){
            System.out.println(x);
        }
        return  returnVal;
    }

    public static final int WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT = parseInt(getConfigProperties("webdriver_timeout"));

    public static final String FACEBOOK_BASEURL = getConfigProperties("fb.baseUrl");
    public static final String FACEBOOK_USERNAME = getConfigProperties("fb.username");

    public static final String FACEBOOK_PASSWORD = getConfigProperties("fb.password");
}
