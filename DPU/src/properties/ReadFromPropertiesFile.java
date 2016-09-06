package properties;

import java.io.InputStream;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ReadFromPropertiesFile {

    public static String imagePath = "src\\images\\";
    public static String propertiesPath = "properties\\";
    public static String filesPath = "src\\files\\";

//    static Logger logger = Logger.getLogger(ReadFromPropertiesFile.class);
    @Bean
    public ReadFromPropertiesFile readFromPropertiesFile() {
//        ReadFromPropertiesFile readFromPropertiesFile = null;
//        if (readFromPropertiesFile == null) {
//            readFromPropertiesFile = new ReadFromPropertiesFile();
//        }
        return new ReadFromPropertiesFile();
    }

    @Bean
    public String getProperty(String property) {
        Properties properties = null;
        try {
            properties = new Properties();
            InputStream is = getClass().getResourceAsStream(propertiesPath + "configuration.properties");
            properties.load(is);
        } catch (Exception e) {
//            logger.error("ReadFromPropertiesFile : getProperty : " + e);
        }
        return properties.getProperty(property);
    }
}
