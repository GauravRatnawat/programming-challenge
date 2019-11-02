package com.anomaly.detector.dto;

public class UpperBoundThresholdAnomalyDetectorDto {
	private String sensorId;
	private String threshold;
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	public String getThreshold() {
		return threshold;
	}
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}
}
