package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMQtestApplication implements CommandLineRunner{
	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMQtestApplication.class, args);
	}
	
	@Bean
	public Queue wiselyQueue() {
		return new Queue("my-queue");
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		rabbitTemplate.convertAndSend("my-queue","来自RabbitMQ的问候" );
		
	}
	
}
