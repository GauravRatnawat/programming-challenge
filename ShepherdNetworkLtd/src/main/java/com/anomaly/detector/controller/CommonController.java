package com.anomaly.detector.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anomaly.detector.dto.EventRequestDto;
import com.anomaly.detector.service.AnomalyDetectorService;

@RestController
@RequestMapping(value = "/")
public class CommonController {

	private static final Logger LOGGER = LogManager.getLogger(CommonController.class);
	@Autowired
	AnomalyDetectorService anomalyDetectorService;
	@RequestMapping(method = RequestMethod.POST, value = "/api/event", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> event(@RequestBody @Valid EventRequestDto eventRequestDto) {
		LOGGER.info("inside event controller");
		return anomalyDetectorService.checkEventAnomaly(eventRequestDto);
	}
}
