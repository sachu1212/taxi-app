package com.sameer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sameer.Repositories.BookingRepository;
import com.sameer.Repositories.UserRepository;
import com.sameer.models.Bookings;
import com.sameer.models.User;

@RestController
public class MainController {
	
	@Autowired
	UserRepository userrepo;
	@Autowired
	BookingRepository BookingRepo;
	
	@RequestMapping(value="/users")
	public ResponseEntity<List<User>> showUsers() {
		return ResponseEntity.ok( userrepo.findAll());
	}

	@RequestMapping(value="/CreateUser", method=RequestMethod.POST)
	public ResponseEntity<User> createuser(User user) {
		userrepo.saveAndFlush(user);
		return ResponseEntity.ok( user);
	}
	
	@GetMapping(path = "/find/{origin}/{destination}")
    public String find(@PathVariable("origin") String origin,
                       @PathVariable("destination") String destination) {
		System.out.println(origin+"..."+destination);
        String apiKey = "AIzaSyDUKloOsTanLHGWlXmV9XakLHC1ERNe1239og";

        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=" + origin + "&destinations=" + destination + "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, String.class);

    }
	
	@RequestMapping(value="/SaveBooking", method=RequestMethod.POST)
	public ResponseEntity<Bookings> saveBooking(Bookings booking) {
		System.out.println(booking.getAddressfrom());
		System.out.println(booking.getAddressto());
		System.out.println(booking.getUsername());
		System.out.println(booking.getBill());
			
		BookingRepo.saveAndFlush(booking);
		return ResponseEntity.ok(booking);
	}


	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<User> loginuser(User user) {

		
		return ResponseEntity.ok( userrepo.searchUser(user.getUsername(),user.getPassword()));
	}
	

}
