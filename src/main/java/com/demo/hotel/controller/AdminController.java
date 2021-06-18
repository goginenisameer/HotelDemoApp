package com.demo.hotel.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.demo.hotel.entity.Hotel;
import com.demo.hotel.entity.Reservation;
import com.demo.hotel.entity.Role;
import com.demo.hotel.services.HotelService;
import com.demo.hotel.services.ReservationService;
import com.demo.hotel.services.UserService;
import com.demo.hotel.temp.CurrentReservation;
import com.demo.hotel.temp.CurrentUser;

@Controller
public class AdminController {

	private UserService userService;

	private ReservationService reservationService;

	private HotelService hotelService;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	public AdminController(UserService userService, ReservationService reservationService, HotelService hotelService) {
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

	@PostMapping("/reservation-delete")
	public String deleteReservation(@RequestParam("resId") int resId) {

		
		
		// delete reservation sent to services to delete from database
		reservationService.deleteReservation(resId);

		return "redirect:/admin-home";
	}
	
	@RequestMapping("/delete-hotel")
	public String deleteHotel(@RequestParam("hotelId")int hotelId) {
		
		hotelService.deleteHotel(hotelId);
		
		return "redirect:/admin-home";
	}
	
	@RequestMapping("/create-hotel")
	public String createHotel(Model model) {
		Hotel hotel=new Hotel();
		model.addAttribute("hotel",hotel);
		return "create-hotel";
	}
	
	@RequestMapping(value = "/save-hotel",method = RequestMethod.POST)
	public String saveHotel(@ModelAttribute("hotel")Hotel hotel)
			throws IOException {
		System.out.println(hotel);
		hotelService.saveHotel(hotel);
		return "redirect:/admin-home";

	}

	@RequestMapping("/admin-home")
	public String adminHotel(Model model) {
		model.addAttribute("allHotels", hotelService.getAllHotels());
		 model.addAttribute("resList", reservationService.getAllReservations());
		return "admin-home";
	}

}
