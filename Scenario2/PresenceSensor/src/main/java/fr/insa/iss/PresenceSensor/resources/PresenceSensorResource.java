package fr.insa.iss.PresenceSensor.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.iss.PresenceSensor.model.PresenceSensor;

@RestController
@RequestMapping("/presence")
public class PresenceSensorResource {
	private PresenceSensor ps = new PresenceSensor();
	@GetMapping
	public boolean getState() {
		return ps.isActive();
	}
	@PutMapping("/newvalue")
	public int newValue(@RequestParam("state") boolean state) {
		ps.setActive(state);
		return 0;
	}
}
