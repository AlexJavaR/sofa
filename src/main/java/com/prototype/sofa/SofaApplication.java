package com.prototype.sofa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class SofaApplication implements CommandLineRunner {

	@Qualifier("dataSource")
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(SofaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("DATASOURCE = " + dataSource);

	}
}
