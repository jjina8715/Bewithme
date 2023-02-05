package com.bewithme.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}

	@GetMapping("/user-list")
	public String indexUsers() {
		return "list.html";
	}

	@GetMapping("/mate-list")
	public String indexMates() {
		return "";
	}

	@GetMapping("/info/wish")
	public String wish() {
		return "tab2.html";
	}
}
