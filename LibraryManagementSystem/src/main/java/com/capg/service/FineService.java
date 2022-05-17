package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.models.Fine;
import com.capg.exception.FineNotFoundException;
import com.capg.repository.FineRepository;
@Service
public class FineService {
	@Autowired  
     FineRepository fineRepository;  
	 
	public ResponseEntity<Fine> createFine(Fine fine){
		Fine fine1 = fineRepository.save( fine);
		return new ResponseEntity<Fine>(fine1, HttpStatus.CREATED);
	}
	public List<Fine> getAllFine(){
		return (List<Fine>)fineRepository.findAll();
	}
	
	public  ResponseEntity<Fine> getFineById( int fineid) throws FineNotFoundException{
		if(fineRepository.findById(fineid).isPresent()) {
			Fine fine = fineRepository.findById(fineid).get();
			return new ResponseEntity<Fine>(fine ,HttpStatus.OK);
		}
		else
		{
			throw new FineNotFoundException("Fine with Id: " +fineid + "doesn't exist !!");
			
		}
	}
	
	public Fine updateFine(@RequestBody Fine fine) {
		return fineRepository.save(fine);
	}
	
	public void deleteFineById( int fineid) {
		
		fineRepository.deleteById(fineid);
	}
	

}
