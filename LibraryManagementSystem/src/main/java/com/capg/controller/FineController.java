package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.FineNotFoundException;
import com.capg.models.Fine;
import com.capg.service.BusinessLogic;
import com.capg.service.FineService;

@RestController
@RequestMapping("/fine")
public class FineController {
	int validFine;
	@Autowired
	private FineService fineService;

	private BusinessLogic logic;

	@PostMapping("/createFine")
	public ResponseEntity<?> createFine(@RequestBody Fine fine) {

		fine.setFineamount(logic.getFine(fine.getNoOfDelayDays()));
		return fineService.createFine(fine);
	}

	@GetMapping("/Allfine")
	public ResponseEntity<?> getAllFine() {

		return ResponseEntity.ok(fineService.getAllFine());

	}

	@GetMapping("/getfine/{fineid}")
	public ResponseEntity<?> getFineById(@PathVariable("fineid") int fineid) throws FineNotFoundException {

		return fineService.getFineById(fineid);

	}

	@DeleteMapping("/fine/{fineid}")
	public void deleteFine(@PathVariable("fineid") int fineid) {

		fineService.deleteFineById(fineid);

	}

	@PutMapping("/upadatefine")
	public ResponseEntity<?> updatefine(@RequestBody Fine fine) {

		return ResponseEntity.ok(fineService.updateFine(fine));

	}

}
