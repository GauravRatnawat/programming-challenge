package com.anomaly.detector.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.anomaly.detector.dto.UpperBoundThresholdAnomalyDetectorDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

@Component
public class ServletContextInjector implements ServletContextAware, InitializingBean {

	private ServletContext servletContext;

	private static final Type REVIEW_TYPE = new TypeToken<List<UpperBoundThresholdAnomalyDetectorDto>>() {
	}.getType();
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {


		servletContext.setAttribute("DATA", getData());  
	}

	private Map<String, Double>  getData() throws FileNotFoundException {
		// TODO Auto-generated method stub

		File dir = new File(ApplicationConstants.FOLDER);
		File[] files = dir.listFiles(new FilenameFilter() { 
			public boolean accept(File dir, String filename)
			{ return filename.endsWith(ApplicationConstants.JSON); }
		} );
		dir.listFiles();
		Map<String, Double> hashdata=new HashMap<String , Double>();
		for(File f: files){
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new FileReader(f));
			List<UpperBoundThresholdAnomalyDetectorDto> data = gson.fromJson(reader, REVIEW_TYPE);
			String key=data.get(0).getSensorId();
			Double value=getvalue(data);
			hashdata.put(key, value);
		}
		return hashdata;
	}

	private Double getvalue(List<UpperBoundThresholdAnomalyDetectorDto> data) {
		Double sum=0.0;
		for(UpperBoundThresholdAnomalyDetectorDto v:data)
		{
			sum=sum+Double.parseDouble(v.getThreshold());
		}
		Double size = new Double(data.size());
		Double ss=sum/size;
		return ss ;
	}

	public void upateContext() throws FileNotFoundException {
		servletContext.setAttribute("DATA", getData());  
	}

}
