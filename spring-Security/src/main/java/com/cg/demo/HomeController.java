package com.cg.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "home1.jsp";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "home2.jsp";
	}
//	@RequestMapping("/")
//	public String home() {
//		return "home.jsp";
//	}
//	
//	@RequestMapping("/user")
//	public String user() {
//		return ("<h1>welcome USER<h1>");
//	}
//	
//	@RequestMapping("/admin")
//	public String admin() {
//		return ("<h2>welcome ADMIN<h2>");
//	}
}
