package com.example.Thyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScans({

		@ComponentScan("com.example"),
})
@SpringBootApplication
public class ThymeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeApplication.class, args);
	}

}
