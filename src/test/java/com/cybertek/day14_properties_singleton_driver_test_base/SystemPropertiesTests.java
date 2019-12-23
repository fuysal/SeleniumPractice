package com.cybertek.day14_properties_singleton_driver_test_base;

import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.Map;
import java.util.Properties;

public class SystemPropertiesTests {
    @Test
    public void systemPropertiesTest1(){
        String os = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");

        String userName = System.getProperty("user.name");

        System.out.println(os+" "+ version+" "+ userName+" "+javaVersion);

        Properties properties = System.getProperties();
        for(Map.Entry<Object, Object> property : properties.entrySet() ) {

            System.out.println("Key: " + property.getKey() + ", Value: " + property.getValue());
        }
    }
}

