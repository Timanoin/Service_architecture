package fr.insa.iss.WindowActuator.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.iss.WindowActuator.model.WindowActuator;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/windowactuator")
public class WindowActuatorResource {
	private WindowActuator Window = new WindowActuator();
	
	@PutMapping("/newvalue")
	public int NewValue(@RequestParam("state") boolean State) {
		Window.setState(State);
		return 0;
	}
	
	@GetMapping
	public boolean GetValue() {
		return Window.getState();
	}
}

