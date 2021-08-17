package com.rad.blk40;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
@EnableScheduling
public class RadBlk40Application {


	public static void main(String[] args) {
		SpringApplication.run(RadBlk40Application.class, args);
	}

}
