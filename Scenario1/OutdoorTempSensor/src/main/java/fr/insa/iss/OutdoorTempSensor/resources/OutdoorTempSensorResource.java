package fr.insa.iss.OutdoorTempSensor.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.insa.iss.OutdoorTempSensor.model.TempSensor;


@RestController
@RequestMapping("/outtempsensor")
public class OutdoorTempSensorResource {
	private TempSensor Sensor = new TempSensor();
	
	@PutMapping("/newvalue")
	public int NewValue(@RequestParam("temp") int Temp) {
		Sensor.setTemp(Temp);
		return 0;
	}
	
	@GetMapping
	public int GetValue() {
		return Sensor.getTemp();
	}
}
