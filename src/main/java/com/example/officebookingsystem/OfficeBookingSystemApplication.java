package com.example.officebookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.officebookingsystem.domain.properties.FileStorage;



@SpringBootApplication
@EnableConfigurationProperties({
        FileStorage.class
})
public class OfficeBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficeBookingSystemApplication.class, args);
    }

}
