package fr.insa.iss.AlarmActuator.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.iss.AlarmActuator.model.AlarmActuator;

@RestController
@RequestMapping("/presence")
public class AlarmActuatorResource {
	private AlarmActuator alarm = new AlarmActuator();
	@GetMapping
	public boolean getState() {
		return alarm.isActive();
	}
	@PutMapping("/newvalue")
	public int newValue(@RequestParam("state") boolean state) {
		alarm.setActive(state);
		return 0;
	}
}

