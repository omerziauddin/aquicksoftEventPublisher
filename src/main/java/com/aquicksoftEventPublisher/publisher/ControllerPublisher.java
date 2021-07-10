package com.aquicksoftEventPublisher.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquicksoftEventPublisher.dto.Order;
import com.aquicksoftEventPublisher.service.ServicePublisher;


@RestController
@RequestMapping(value= "/hi")
public class ControllerPublisher {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	ServicePublisher servicePublisher;

	
	@PostMapping(value= "/userDetails")
	public ResponseEntity<Order> createuserDetails(@RequestBody final Order order) {
		logger.info("Creating new user Details= " + order.toString());
		final Order response = servicePublisher.publishEventToRabbitMq(order);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}