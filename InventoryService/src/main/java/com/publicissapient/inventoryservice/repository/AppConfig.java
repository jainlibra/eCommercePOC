package com.publicissapient.inventoryservice.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;

@Configuration
public class AppConfig {
	
	@Value("${spring.data.mongodb.uri}")
    private String mongoUri;
  
  public @Bean MongoClient mongoClient() {
      return new MongoClient(new MongoClientURI(mongoUri));
  }

  public @Bean MongoTemplate mongoTemplate() {
      MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(),"ecom_inventory");
      mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
      return mongoTemplate;
  }
}
