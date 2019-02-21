package com.example.springdatamongodb.interfaces;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springdatamongodb.model.UserDTO;


@Repository
public interface UserMongodbRepository extends MongoRepository<UserDTO, String>
{
	
	
	@Query(value = "{'date':{ $lt: ?0, $gt: ?1}}")
	List<UserDTO> findByDateBetween(Instant from, Instant to);
 

}
