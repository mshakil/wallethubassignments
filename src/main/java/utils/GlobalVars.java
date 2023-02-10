package utils;

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

    public static final String WALLET_HUB_LOGIN_URL = getConfigProperties("wallet.hub.login");

    public static final String WALLET_HUB_USER_NAME = getConfigProperties("wallet.hub.user.name");

    public static final String WALLET_HUB_USER_PASSWORD = getConfigProperties("wallet.hub.user.password");

    public static final String WALLET_HUB_PROFILE_NAME = getConfigProperties("wallet.hub.profile.name");

    public static final String WALLET_HUB_PROFILE_URL = getConfigProperties("wallet.hub.profile.url");

}
