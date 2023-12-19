package fr.insa.iss.BlindsActuator.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.iss.BlindsActuator.model.BlindsActuator;

@RestController
@RequestMapping("/blindsactuator")
public class BlindsActuatorResource {
	private BlindsActuator blinds = new BlindsActuator();
	
	@PutMapping("/newvalue")
	public int NewValue(@RequestParam("state") boolean State) {
		blinds.setState(State);
		return 0;
	}
	
	@GetMapping
	public boolean GetValue() {
		return blinds.getState();
	}
}
