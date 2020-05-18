package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.exceptions.IdNotFoundException;
import com.cap.service.CancelBookingService;

@RestController
@RequestMapping("/Flights")
@CrossOrigin("http://localhost:4200")
public class CancelBookingController  {
	@Autowired
    CancelBookingService service;

	@DeleteMapping("/cancelBooking/{bookingId}")
	  public ResponseEntity<Boolean>  deleteBookingDetails(@PathVariable Integer bookingId) {
	  Boolean booking=service.getBookingData(bookingId);
	if(Boolean.TRUE.equals(booking))
	{
	service.deleteBookingDetails(bookingId);
	return new ResponseEntity<>(true, new HttpHeaders(), HttpStatus.OK);
	}
	else
		throw new IdNotFoundException("BookingId is not found");
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> BookingIdNotFound(IdNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	
}

