package com.aquicksoftEventPublisher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.aquicksoftEventPublisher.dto.Order;
import com.aquicksoftEventPublisher.dto.OrderListen;
import com.aquicksoftEventPublisher.dto.Stats;

@Service
public class ServicePublisher {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Value("${QC_TASK_START}")
	String qcTaskStart;
	
	@Value("${QC_STATS}")
	String QC_STATS;

	@Value("${QC_LISTEN}")
	String QC_LISTEN;
	
	@Async
	public Order publishEventToRabbitMq(final Order order) {
		logger.info("Sending the following event object to the queue: " + order);
		
		rabbitTemplate.convertAndSend(qcTaskStart, order);
		logger.info("Message successfully sent to the rabbitMq.");
		
		Stats stats=new Stats();
		stats.setAction("successfull");
		stats.setTxId(order.getTxId());
		
		publishStats(stats);
		return order;
	}
	
	@Async
	public void publishStats(final Stats stats)
	{
logger.info("Sending the following event object to the queue: " + stats);
		
		rabbitTemplate.convertAndSend(QC_STATS, stats);
		logger.info("Message successfully sent to the rabbitMq.");
	}
	
	
	
	

	@RabbitListener(queues = "${QC_LISTEN}")
	public void recievedMessage(final OrderListen orderListen) {
		System.out.println("Received following message from rabbitmq= " + orderListen);
		
	}
}