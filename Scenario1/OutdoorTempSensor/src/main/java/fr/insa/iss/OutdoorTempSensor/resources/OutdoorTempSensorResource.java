package fr.insa.iss.OutdoorTempSensor.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.insa.iss.OutdoorTempSensor.model.TempSensor;


@RestController
@RequestMapping("/outtemp")
public class OutdoorTempSensorResource {
	private TempSensor sensor = new TempSensor();

	// PUT request that updates the current saved value.
	@PutMapping("/newvalue")
	public int newValue(@RequestParam("temperature") int temp) {
		sensor.setTemp(temp);
		return 0;
	}

	// GET request that returns the saved value.
	@GetMapping
	public int getValue() {
		return sensor.getTemp();
	}
}
