package com.arman_portfolio.portfolio.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		//System.out.println(name + " "+ email+ " "+subject+" "+message);
		return "success";
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadfile() throws IOException 
	{	
		String filename = "C:/Arman/arman_DevOps_Resume.pdf";
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Contend-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires","0");
		
		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/pdf")).body(resource);
		System.out.println("Someone downloaded resume....");
	
		return responseEntity;
	}

}
