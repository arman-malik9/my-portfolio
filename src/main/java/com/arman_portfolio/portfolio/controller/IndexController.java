package com.arman_portfolio.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.arman_portfolio.portfolio.model.ContactUs;


@Controller
public class IndexController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@PostMapping("/contactus")
	public String registeration(@ModelAttribute ContactUs contactUs)
	{
		String name = contactUs.getName();
		String email = contactUs.getEmail();
		String subject = contactUs.getSubject();
		String message = contactUs.getMessage();
		System.out.println(contactUs);
		System.out.println(name + " "+ email+ " "+subject+" "+message);
		
		return "success";
	}
}