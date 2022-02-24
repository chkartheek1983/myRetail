package com.target.rtl.myRetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyRetailAppV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailAppV1Application.class, args);
	}

}
