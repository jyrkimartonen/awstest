package net.tutorit.awstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({ "classpath:persistance-${envTarget:dev}.properties" })
public class AwsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsTestApplication.class, args);
	}

}
