# Anomaly detector

Anomaly detector problem solution in Java

## Run

Build a fat war

```bash
mvn clean install
```
Inside target folder run the application

java -jar AnomalyDetectorApplication-0.1.war



## Configuration 
Configuration files format inside ConfigurationFiles Folder. For each sensor there is a different config file with name of sensor id.

Ex. fd0a635d-2aaf-4460-a817-6353e1b6c050.json

```python
[
  {
    "sensorId" : "fd0a635d-2aaf-4460-a817-6353e1b6c050",
     "model": "UpperBoundThresholdAnomalyDetector",
     "threshold": "27.0"
},
   {
    "sensorId" : "fd0a635d-2aaf-4460-a817-6353e1b6c050",
     "model": "UpperBoundThresholdAnomalyDetector",
     "threshold": "27.0"
}
]
```

## Example
Post localhost:8181/api/event

Body:

```python
{
    "eventId" : "cj86g5ypk000004zvevipqxfn",
    "sensorId" : "fd0a635d-2aaf-4460-a817-6353e1b6c050",
    "timestamp" : "1506723249",
    "value" : "28.6734"
}
```

Response: 200 OK

```python
{
    "eventId": "cj86g5ypk000004zvevipqxfn",
    "cause": "Upper Bound Threshold Detector",
    "message": "Exceeds threshold",
    "value": "28.6734",
    "sensorId": "fd0a635d-2aaf-4460-a817-6353e1b6c050",
    "timestamp": "1506723249",
    "status": "ANOMALY"
}
```
