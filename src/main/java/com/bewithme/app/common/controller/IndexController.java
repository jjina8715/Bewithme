package com.bewithme.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	@GetMapping("/info/wish")
	public String wish() {
		return "tab2.html";
	}
}
