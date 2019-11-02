package com.anomaly.detector;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.anomaly.detector.utility.GeneralUtil;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AnomalyDetectorApplication {

    public AnomalyDetectorApplication() {
        super();
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AnomalyDetectorApplication.class);
        springApplication.run(args);
        springApplication.setBannerMode(Mode.OFF);
        GeneralUtil.printMemory();
    }

 
}
