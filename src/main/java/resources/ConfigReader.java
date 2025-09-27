package resources;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties properties;
    String path = "src/main/resources/config.properties";

    public ConfigReader() {

        try {

            properties = new Properties();

            FileInputStream fs = new FileInputStream(path);
            properties.load(fs);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getBaseUrl() {
        String url = properties.getProperty("baseUrl");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("url not specified in config file");
        }

    }

    public String getbrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) {
            return browser;
        } else {
            throw new RuntimeException("browser not specified in config file");
        }
    }

}
