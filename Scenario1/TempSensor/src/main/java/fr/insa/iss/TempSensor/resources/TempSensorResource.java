package fr.insa.iss.TempSensor.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.insa.iss.TempSensor.model.TempSensor;


@RestController
@RequestMapping("/temp")
public class TempSensorResource {
	private TempSensor sensor = new TempSensor();
	
	@PutMapping("/newvalue")
	public int newValue(@RequestParam("temperature") int temp) {
		sensor.setTemp(temp);
		return 0;
	}
	
	@GetMapping
	public int getValue() {
		return sensor.getTemp();
	}
}
