/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kishore.servicebus.service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.servicebus.vo.Course;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.QueueClient;

@RestController
public class CourseController {

	private final Logger logger = LoggerFactory.getLogger(CourseController.class);
	@Autowired
	private QueueClient queueClient;

	@PostMapping(path = "/Course")
	public ResponseEntity<String> postCourse(@RequestBody Course course) {
		try {
			logger.info("Received message: {}", course.getCourseName());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(out);
			os.writeObject(course);

			Message message = new Message(out.toByteArray());
			message.setMessageId(course.getCourseId());
			message.setTimeToLive(Duration.ofMinutes(15));
			queueClient.send(message);
			queueClient.close();
			return new ResponseEntity<>("Course is Posted" + course.getCourseName(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to post Course" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
