package com.avneet.washerservice.service;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.avneet.washerservice.model.DatabaseSequence;
import com.avneet.washerservice.model.Washerdetails;
import com.avneet.washerservice.repository.WasherRepository;

@Service
public class WashSerciveImp implements WashService {
	
	@Autowired
	private WasherRepository repo;
    	
	

	@Override
	public Washerdetails addWasher(Washerdetails washer) {
		return repo.save(washer);
	
	}

	@Override
	public List<Washerdetails> getwashers() {
		List<Washerdetails> washer =repo.findAll();
		System.out.println("Getting data from DB :" +washer);
		return washer;
	}

	@Override
	public List<Washerdetails> getwasherbylocation(String location) {
		return repo.findBylocation(location);
	}

	@Override
	public void deletewasher(Washerdetails washer) {
		repo.delete(washer);
		
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
