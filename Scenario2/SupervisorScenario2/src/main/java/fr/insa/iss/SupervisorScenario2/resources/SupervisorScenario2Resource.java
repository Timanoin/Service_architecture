package fr.insa.iss.SupervisorScenario2.resources;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/scenario2")
public class SupervisorScenario2Resource {
	@PutMapping("/alarmcompute")
	public int alarmMonitor() {
		// RestTemplate for sending requests
		RestTemplate restTemplate = new RestTemplate();
		
		// Create headers if necessary
        HttpHeaders headers = new HttpHeaders();
        // Create an empty HttpEntity (no body)
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        
		// get all students information
		int currHourTime = restTemplate.getForObject("http://localhost:8085/time/", int.class);
		// get all students evaluation
		boolean presence = restTemplate.getForObject("http://localhost:8086/presence/", boolean.class);
		
		if (presence && (currHourTime>=22 || currHourTime<6)) {
	        // Activate alarm
	        restTemplate.put("http://localhost:8090/alarm/newvalue?state=true", requestEntity);
		}
		else {
			// Stop alarm
	        restTemplate.put("http://localhost:8090/alarm/newvalue?state=false", requestEntity);
		}
		
		return 0;	
	}
	
	@PutMapping("/lightcompute")
	public int lightsMonitor() {
		// RestTemplate for sending requests
		RestTemplate restTemplate = new RestTemplate();
		
		// Create headers if necessary
        HttpHeaders headers = new HttpHeaders();
        // Create an empty HttpEntity (no body)
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        
		// get all students information
		int currHourTime = restTemplate.getForObject("http://localhost:8085/time/", int.class);
		// get all students evaluation
		boolean presence = restTemplate.getForObject("http://localhost:8086/presence/", boolean.class);
		
		if ((currHourTime>22 || currHourTime<6) || !presence) {
	        // Turn off the lights, close the blinds and the doors
	        restTemplate.put("http://localhost:8087/door/newvalue?state=false", requestEntity);
	        restTemplate.put("http://localhost:8088/blinds/newvalue?state=false", requestEntity);
	        restTemplate.put("http://localhost:8089/light/newvalue?state=false", requestEntity);
		}
		else {
			// Turn on the lights, open the blinds and the doors
	        restTemplate.put("http://localhost:8087/door/newvalue?state=true", requestEntity);
	        restTemplate.put("http://localhost:8088/blinds/newvalue?state=true", requestEntity);
	        restTemplate.put("http://localhost:8089/light/newvalue?state=true", requestEntity);
		}
		
		return 0;	
	}
}
