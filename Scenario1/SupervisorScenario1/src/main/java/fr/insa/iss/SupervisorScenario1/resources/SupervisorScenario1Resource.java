package fr.insa.iss.SupervisorScenario1.resources;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/scenario1")
public class SupervisorScenario1Resource {
	// RestTemplate for sending requests
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/sensorin")
	public int sensorInMonitor() {
				
		// get temperature inside
		int tempIn = restTemplate.getForObject("https://tempsensor-app.azurewebsites.net/temp", int.class);
		
		return tempIn;
	}
	
	@GetMapping("/sensorout")
	public int sensorOutMonitor() {
		// get temperature outside
		int tempOut = restTemplate.getForObject("https://outdoortempsensor.azurewebsites.net/outtemp", int.class);
		
		return tempOut;
	}
	
	@PutMapping("/compute")
	public int windowMonitor() {
		
		// Create headers if necessary
        HttpHeaders headers = new HttpHeaders();
        // Create an empty HttpEntity (no body)
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        
		// get temperatures
        int tempOut = this.sensorOutMonitor();
        int tempIn = this.sensorInMonitor();
		
		if ((tempOut<tempIn)&&(tempOut<=27)&&(tempOut>=18)) {
	        // Open the window if temperature outside between [18;27] and if inside temperature is higher than outside one
	        restTemplate.put("https://windowactuator-app.azurewebsites.net/window/newvalue?state=true", requestEntity);
		}
		else {
			// Else close the window
	        restTemplate.put("https://windowactuator-app.azurewebsites.net/window/newvalue?state=false", requestEntity);
		}
		
		return 0;	
	}
}
