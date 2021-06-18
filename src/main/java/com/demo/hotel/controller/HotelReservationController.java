package com.demo.hotel.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.hotel.entity.Hotel;
import com.demo.hotel.entity.Reservation;
import com.demo.hotel.entity.Role;
import com.demo.hotel.services.HotelService;
import com.demo.hotel.services.ReservationService;
import com.demo.hotel.services.UserService;
import com.demo.hotel.temp.CurrentReservation;
import com.demo.hotel.temp.CurrentUser;

@Controller
public class HotelReservationController {

	private UserService userService;

	private ReservationService reservationService;

	private HotelService hotelService;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	public HotelReservationController(UserService userService, ReservationService reservationService,
			HotelService hotelService) {
		this.userService = userService;
		this.reservationService = reservationService;
		this.hotelService = hotelService;
	}

	// data binder
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// home page
	@RequestMapping("/")
	public String homePage(Model model) {

		model.addAttribute("isUserAdmin", isAdmin(userService.getLoggedUser().getRoles()));
		return "home-page";
	}

	private Boolean isAdmin(Collection<Role> roles) {
		for (Role value : roles) {
			if (value.getName().equals("ROLE_ADMIN")) {
				return true;
			}
		}
		return false;
	}

	// login page
	@GetMapping("/login-form-page")
	public String loginPage(Model model) {

		// if user is already login, redirect to home
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "redirect:/";
		}

		// new user attribute for sign up page
		model.addAttribute("newUser", new CurrentUser());

		return "login";
	}

	// registration process page
	@PostMapping("/processRegistration")
	public String processRegistrationForm(@Valid @ModelAttribute("newUser") CurrentUser currentUser,
			BindingResult theBindingResult, Model model) {

		// check the database if user already exists
		if (userService.findUserByEmail(currentUser.getEmail()) != null) {
			model.addAttribute("newUser", new CurrentUser());
			model.addAttribute("registrationError", "Email already exists.");

			return "login";
		}

		// create user account
		userService.saveUser(currentUser);
		model.addAttribute("registrationSuccess", "registration Success.");

		return "redirect:/login-form-page";

	}

	// booking page
	@RequestMapping("/book-room")
	public String bookRoom(Model model) {

		model.addAttribute("allHotels", hotelService.getAllHotels());

		return "book";
	}

	@RequestMapping(value = "/new-reservation", method = RequestMethod.POST)
	public String newReservation(Model model, @RequestParam("hotelId") int hotelId) {
		// reservation attribute

		Hotel hotelById = hotelService.getHotelById(hotelId);
		if (null == hotelById) {
			return "error";
		}

		CurrentReservation currentReservation = new CurrentReservation();

		currentReservation.setHotelName(hotelById.getHotelName());
		currentReservation.setHotelPrice(hotelById.getHotelPrice());
		currentReservation.setStatus("Active");

		model.addAttribute("newRes", currentReservation);

		return "reservation-page";
	}

	// save new reservation
	@PostMapping("/proceed-reservation")
	public String proceedReservation(@Valid @ModelAttribute("newRes") CurrentReservation currentReservation,
			BindingResult theBindingResult, Model model) {

		// send reservation to services to save it in database
		reservationService.saveOrUpdateReservation(currentReservation);

		return "redirect:/your-reservations";
	}

	// reservations of user
	@GetMapping("/your-reservations")
	public String reservationsList(Model model) {

		// list of reservations for logged user
		model.addAttribute("resList", reservationService.getReservationsForLoggedUser());

		return "your-reservations";
	}

	// update reservation
	@PostMapping("/reservation-update")
	public String updateReservation(@RequestParam("resId") int resId,Model model) {

		Reservation user = reservationService.getReservationForLoggedUserById(resId);
		user.setStatus("Requested");
		reservationService.setStatus(user);
		return "redirect:/your-reservations";
	}

	// log out
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

		// handle logout for logged user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login-form-page?logout";
	}

}