package com.anomaly.detector.service;

import java.util.Map;

import com.anomaly.detector.dto.EventRequestDto;

public interface AnomalyDetectorService {
	 Map<String, Object> checkEventAnomaly(EventRequestDto eventRequestDto);
}
