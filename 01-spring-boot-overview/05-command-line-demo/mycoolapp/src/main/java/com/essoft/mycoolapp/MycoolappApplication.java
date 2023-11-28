package com.essoft.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MycoolappApplication {

	// If you want, you can run this app from command line
	//for creating package mvnw package
	//after that you can run java -jar target\mycoolapp-0.0.1-SNAPSHOOT.jar

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

}
