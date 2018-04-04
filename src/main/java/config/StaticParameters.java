

/**
 * Created by Renat on 01.07.2016.
 */
public class StaticParameters {

    private static final String BASE_URL = System.getProperty("base_url");
    public static final String USERNAME = "daniilprytkov1";
    public static final String AUTOMATE_KEY = "GPFzuC5Lxw8bXztJpujN";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    public static final String DRIVER_WIN_PATH  = "drivers/win/chromedriver.exe";
    public static final String DRIVER_UNIX_PATH = "usr/bin/chromedriver";

    public static final String devCredentialsPath = "src/main/resources/credentials/credentials_dev.properties";
    public static final String predProdCredentialsPath = "src/main/resources/credentials/credentials_predprod.properties";

    public static final String prodCredentialsPath = "src/main/resources/credentials/credentials_prod.properties";

    public String getBaseUrl() { return BASE_URL; }
}
