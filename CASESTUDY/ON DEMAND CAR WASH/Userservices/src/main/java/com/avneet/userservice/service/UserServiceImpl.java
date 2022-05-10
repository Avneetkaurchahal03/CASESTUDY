package com.avneet.userservice.service;

import java.util.List;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.avneet.userservice.model.DatabaseSequence;
import com.avneet.userservice.model.UserLogin;
import com.avneet.userservice.repository.userRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private userRepository repo;
	
	   
	@Override
	public UserLogin addUser(UserLogin userLogin) {
		return repo.save(userLogin);
	
	}
	
	@Override
	public List<UserLogin> getuser() {
		List<UserLogin> users=repo.findAll();
		System.out.println("Getting data from DB : " +users);
		return users;
	}

	@Override
	public String Updateuser(UserLogin update) {
		   repo.save(update);
		    return "user updated";
	}
	
	
	@Override
	public String deleteById(Integer id) {
		 repo.deleteById(id); 
		  return "user deleted";
	}
	
	
	@Override
	public String deleteUser(UserLogin user) {
		 repo.delete(user);
		  return "user deleted";
	}
	

	@Override
	public String deleteUser(Integer id) {
		repo.deleteById(id);
		return  "deleted";
	}
	
	
	  @Autowired
	  private MongoOperations mongoOperations;



	  public int getSequenceNumber(String sequenceName) {
	  //get sequence no
	  Query query = new Query(Criteria.where("id").is(sequenceName));
	  //update the sequence no
	  Update update = new Update().inc("seq", 1);
	  //modify in document
	  DatabaseSequence counter = mongoOperations.findAndModify(query,
	  update, options().returnNew(true).upsert(true),
	  DatabaseSequence.class);

	  return (int) (!Objects.isNull(counter) ? counter.getSeq() : 1);


	  }
}


		