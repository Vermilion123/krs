package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Renat on 02.06.2016.
 */
public class PropertyUtils {

    private final String PATH = "src/main/resources/bs.properties";
    private FileInputStream fis;
    private Properties properties;

    public PropertyUtils() {}

    private void read() throws IOException {
        fis = new FileInputStream(PATH);
    }

    private void load() throws IOException {
        read();
        properties.load(fis);
    }

    public Properties getInstance() throws IOException {
        load();
        return properties;
    }

    public static void main(String[] args) throws IOException {
        Properties pr = new PropertyUtils().getInstance();
        System.out.println(pr.getProperty("bs.log_test"));
    }
	

}
