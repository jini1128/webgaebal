package com.tj.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/test.jsp";
	}
	@RequestMapping("/test")
	public String aa() {
		return "/WEB-INF/views/test1.jsp";
	}
}
