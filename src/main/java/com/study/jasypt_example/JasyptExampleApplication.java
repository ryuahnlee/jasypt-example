package com.study.jasypt_example;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class JasyptExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasyptExampleApplication.class, args);
	}

}
