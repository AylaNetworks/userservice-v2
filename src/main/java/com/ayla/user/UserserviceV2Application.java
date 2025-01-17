package com.ayla.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"com.ayla"})
@EnableWebMvc
@EnableCaching
@EnableScheduling
public class UserserviceV2Application {

    public static void main(String[] args) {
        System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true");
        try {
            SpringApplication.run(UserserviceV2Application.class, args);
        } catch (Exception e) {
            throw e;
        }
    }

}
