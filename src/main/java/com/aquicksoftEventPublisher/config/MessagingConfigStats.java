package com.aquicksoftEventPublisher.config;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessagingConfigStats {

	@Value("${QC_STATS}")
	String QC_STATS;

	@Bean
	Queue queueStats() {
		return new Queue(QC_STATS);
	}

	@Bean
	Jackson2JsonMessageConverter producerJackson2MessageConverterStats() {
		return new Jackson2JsonMessageConverter();
	}
}
