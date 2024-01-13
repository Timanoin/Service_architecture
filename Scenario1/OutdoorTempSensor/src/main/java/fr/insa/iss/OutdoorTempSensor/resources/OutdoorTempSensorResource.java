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
	private TempSensor Sensor = new TempSensor();

	// PUT request that updates the current saved value.
	@PutMapping("/newvalue")
	public int NewValue(@RequestParam("temp") int Temp) {
		Sensor.setTemp(Temp);
		return 0;
	}

	// GET request that returns the saved value.
	@GetMapping
	public int GetValue() {
		return Sensor.getTemp();
	}
}
