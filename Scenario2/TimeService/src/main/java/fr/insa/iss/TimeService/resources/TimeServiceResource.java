package fr.insa.iss.TimeService.resources;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeServiceResource {
	@GetMapping
	public int getCurrentHour() {
		Instant instant = Instant.now();
	    // convert the instant to a local date time of your system time zone
	    LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	    return ldt.getHour();
	}
	
}
