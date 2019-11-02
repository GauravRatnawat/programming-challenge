package com.anomaly.detector.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.anomaly.detector.dto.EventRequestDto;
import com.anomaly.detector.service.AnomalyDetectorService;
import com.anomaly.detector.utility.ApplicationConstants;

public class AnomalyDetectorServiceImpl implements AnomalyDetectorService{


	private static final Logger LOGGER = LogManager.getLogger(AnomalyDetectorServiceImpl.class);
	@Autowired
	ServletContext servletContext;
	
	

	@Override
	public Map<String, Object> checkEventAnomaly(EventRequestDto eventRequestDto) {
		  {
				Map<String, Object> responseMap = new HashMap<>();

				LOGGER.info("inside event");

				Map<String, Double> hashdata  = (Map<String, Double>) servletContext.getAttribute("DATA");

				responseMap.put(ApplicationConstants.EVENT_ID, eventRequestDto.getEventId());
				responseMap.put(ApplicationConstants.SENSOR_ID, eventRequestDto.getSensorId());
				responseMap.put(ApplicationConstants.TIMESTAMP, eventRequestDto.getTimestamp());
				responseMap.put(ApplicationConstants.VALUE,eventRequestDto.getValue());
				if(hashdata.containsKey(eventRequestDto.getSensorId()))
				{
					Double double1 = hashdata.get(eventRequestDto.getSensorId());
					if(double1>Double.parseDouble(eventRequestDto.getValue()))
					{
						responseMap.put(ApplicationConstants.STATUS, "NO_ANOMALY");
						responseMap.put(ApplicationConstants.CAUSE, "");
						responseMap.put(ApplicationConstants.MESSAGE,
								"");
					}
					else
					{
						responseMap.put(ApplicationConstants.STATUS, "ANOMALY");
						responseMap.put(ApplicationConstants.CAUSE, "Upper Bound Threshold Detector");
						responseMap.put(ApplicationConstants.MESSAGE,
								"Exceeds threshold");
					}
				}else
				{
					responseMap.put(ApplicationConstants.STATUS, "NO_MODEL");
					responseMap.put(ApplicationConstants.CAUSE, "");
					responseMap.put(ApplicationConstants.MESSAGE,
							"");
				}
				return responseMap;
			}
	}

}
