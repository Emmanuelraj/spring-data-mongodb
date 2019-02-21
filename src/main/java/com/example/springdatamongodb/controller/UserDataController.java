package com.example.springdatamongodb.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatamongodb.interfaces.UserMongodbRepository;
import com.example.springdatamongodb.model.Address;
import com.example.springdatamongodb.model.UserDTO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.gridfs.GridFSDBFile;

@RestController
public class UserDataController 
{
	
	@Autowired
	private UserMongodbRepository  userMongodbRepository;
	
	
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	
	
	@Autowired
	private GridFsTemplate gridfsTemplate;
	
	
	
	
	
	
   @GetMapping("/hi")
   public String hi()
   {
	   System.out.println("hi");
	   return "hi";
	   
   }
	
   
   @GetMapping("/userId/{_id}")
   public Optional<UserDTO> findById(@PathVariable("_id") String id)
   {
	   System.out.println(id);
	   
	   
	   return userMongodbRepository.findById(id);
	   
   }
   
   
   
   @GetMapping("/all")
   public List<UserDTO> load() throws FileNotFoundException
   {
	   
	   Path file = Paths.get("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
	   
	   
	   System.out.println("load all"+file);
	   System.out.println(file.getFileName().toString());
	   
	    
	   
	       userMongodbRepository.save(new UserDTO("5", "Emmanuel", new Date("06/10/1992"), "Spring Developer", new Address("Koramangala", "BLR", "Karanataka", 12340), new Date()));
	       DBObject metaData = new BasicDBObject();
	       metaData.put("user", "Emmanuel Raj");
	       
	       
	       
	       InputStream ip = new FileInputStream(file.toString());
	       gridfsTemplate.store(ip, file.toString(), "image/jpg", metaData).toString();
	   
	       
	       System.out.println(gridfsTemplate.find(new Query()).first());
	       
	       return  userMongodbRepository.findAll();
   }
   
   
   
   
   @GetMapping("/delById/{_id}")
   public List<UserDTO> deleteById(@PathVariable("_id") String id)
   {
	   System.out.println("delete mapping"+id);
	   userMongodbRepository.deleteById(id);
	   return userMongodbRepository.findAll();
   }
   
   
   
   
   
   
   @GetMapping("/editById/{_id}")
   public String  updateById(@PathVariable("_id") String id)
   {
	   System.out.println("updatedById"+id);
	   List<UserDTO> userList = userMongodbRepository.findAll();
	      for(UserDTO ls : userList)
		   {
			   if(ls.getId().equals(id))
			   {
				   ls.setAddress(new Address("thonglang akutpa", "IMF", "Manipur", 12343) );
				   ls.setDob(new Date("03/10/1994"));
				   ls.setCreatedDate(new Date());
				   ls.setDescription("software engineer");
				   ls.setName("Imman");
				   
				   
				   userMongodbRepository.save(ls);
			   }
		  }
  	   Optional<UserDTO> check=userMongodbRepository.findById(id);
		   if(check.isPresent())
		   {
			   return "Updated";   
		   }
		   else
		   {
			   return "Not Updated _id not exists !";
		   }
	}
   
   
   
   
   
      //Between two dates find n no of users   spring data date between
     @SuppressWarnings("deprecation")
	@GetMapping("/btwnId/{startId}/{endId}")
     public String betweenId(@PathVariable("startId")String start, @PathVariable("endId")String end) throws Exception
     {
    	 
       //intro Query 
       	Query query = new Query();
    	 
       	query.addCriteria(Criteria.where("_id").gte(start).lt((end)));
   	 
    	 
    	 //Query query = new Query();
    	// query.addCriteria(Criteria.where("age").lt(50).gt(20));
      
       //	List<UserDTO> users = userMongodbRepository.find(query,UserDTO.class);
       	List<UserDTO> users = mongoTemplate.find(query, UserDTO.class);
        System.out.println(query.getMeta()+""+users);
    	 return query.getHint();
    	 
    	 
     }
   
     
   
   @GetMapping("/delete/image/{_id}")
   public String deleteFile(@PathVariable("_id")String id)
   {
	   System.out.println("deleteFileById"+id);
	   gridfsTemplate.delete(new Query(Criteria.where("_id").is(id)));
	   return "Done"; 
   }
   
   
   
   
   
   
   

}
