package fr.insa.iss.LightActuator.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.iss.LightActuator.model.LightActuator;

@RestController
@RequestMapping("/light")
public class LightActuatorResource {
	private LightActuator light = new LightActuator();
	@GetMapping
	public boolean getState() {
		return light.isActive();
	}
	@PutMapping("/newvalue")
	public int newValue(@RequestParam("state") boolean state) {
		light.setActive(state);
		return 0;
	}
}

