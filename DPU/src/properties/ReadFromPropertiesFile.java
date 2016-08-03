package properties;

import java.io.InputStream;
import java.util.Properties;

public class ReadFromPropertiesFile {

    public static String applicationPath = "DPU\\src\\";
    static ReadFromPropertiesFile readFromPropertiesFile = null;
    Properties properties = null;
//    static Logger logger = Logger.getLogger(ReadFromPropertiesFile.class);

    private ReadFromPropertiesFile() {
    }

    public static ReadFromPropertiesFile getInstance() {
        if (readFromPropertiesFile == null) {
            readFromPropertiesFile = new ReadFromPropertiesFile();
        }
        return readFromPropertiesFile;
    }

    public String getProperty(String property) {
        try {
            properties = new Properties();
            InputStream is = getClass().getResourceAsStream(applicationPath + "properties\\configuration.properties");
            properties.load(is);
        } catch (Exception e) {
//            logger.error("ReadFromPropertiesFile : getProperty : " + e);
        }
        return properties.getProperty(property);
    }
}
