package hf.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class RabbitMqErrorHandler implements ErrorHandler {
	
	private static Logger logger = LoggerFactory
			.getLogger(RabbitMqErrorHandler.class);
	
	public void handleError(Throwable t) {
		logger.error("Receive rabbitmq message error:{}", t); // error
	}

}
