package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfClass {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try {
            fileInputStream = new FileInputStream(getConfigFilePath());
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    //Возвращает путь conf в зависимости от профиля
    public static String getConfigFilePath() {
        String env = System.getProperty("env");
        return "src/main/resources/" + env + "/conf.properties";
    }
}
