package com.kishore.servicebus.service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.servicebus.vo.StockPortFolio;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.TopicClient;

@RestController
public class StockPortFolioController {
	 private final Logger logger = LoggerFactory.getLogger(StockPortFolioController.class);
	  
	 @Autowired
	 private TopicClient topicClient;
	  
	@PostMapping(path = "/StockPortFolio")
	public ResponseEntity<String>  postStockPrice(@RequestBody StockPortFolio stockPortFolio ) {
		try {
		logger.info("Received message: {}", stockPortFolio.getStockSymbol());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(stockPortFolio);
	   
		Message message = new Message(out.toByteArray());
		message.setLabel(stockPortFolio.getCategory());
        topicClient.send(message);
        return new ResponseEntity<>(
        	      "StockPortFolio is Posted" + stockPortFolio.getStockSymbol(), 
        	      HttpStatus.CREATED);
		
		}
		catch(Exception e)
		{
			 return new ResponseEntity<>(
	        	      "Failed to Post StockPortFolio " + e.getMessage(), 
	        	      HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
