package fr.insa.iss.DoorActuator.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.iss.DoorActuator.model.DoorActuator;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/door")
public class DoorActuatorResource {
	private DoorActuator door = new DoorActuator();
	
	@PutMapping("/newvalue")
	public int NewValue(@RequestParam("state") boolean State) {
		door.setState(State);
		return 0;
	}
	
	@GetMapping
	public boolean GetValue() {
		return door.getState();
	}
}