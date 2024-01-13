package fr.insa.iss.WindowActuator.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.iss.WindowActuator.model.WindowActuator;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/window")
public class WindowActuatorResource {
	private WindowActuator window = new WindowActuator();
	
	@PutMapping("/newvalue")
	public int newValue(@RequestParam("state") boolean State) {
		window.setState(State);
		return 0;
	}
	
	@GetMapping
	public boolean getValue() {
		return window.getState();
	}
}

