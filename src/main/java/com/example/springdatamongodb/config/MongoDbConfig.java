package com.example.springdatamongodb.config;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdatamongodb.interfaces.UserMongodbRepository;
import com.example.springdatamongodb.model.Address;
import com.example.springdatamongodb.model.UserDTO;

@EnableMongoRepositories(basePackageClasses=UserMongodbRepository.class)
@Configuration
public class MongoDbConfig //implements CommandLineRunner
{
	
	@Autowired
	private UserMongodbRepository  userMongodbRepository;

	
	
	//@Transactional
	//@Override
	
	/**
	public void run(String... args) throws Exception
	{
		// TODO create an Object
		
		
	
		   userMongodbRepository.save(new UserDTO("5", "Emmanuel", new Date("06/10/1992"), "Spring Developer", new Address("Koramangala", "BLR", "Karanataka", 12340), new Date()));
		    
	  
	}
	*/
	
	
	
	
	
	

}
