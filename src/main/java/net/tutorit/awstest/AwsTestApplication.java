package net.tutorit.awstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@PropertySource({ "classpath:application-${envTarget:dev}.properties" })
public class AwsTestApplication {

	@Bean
	public RestTemplate restTemplate(){
		RestTemplateBuilder builder=new RestTemplateBuilder();
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(AwsTestApplication.class, args);
	}

}
