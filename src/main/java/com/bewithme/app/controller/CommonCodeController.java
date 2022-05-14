package com.bewithme.app.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bewithme.data.type.Game;

@Controller
@RequestMapping("/codes")
public class CommonCodeController {

	@GetMapping("/game")
	@ResponseBody
	public List<Game> getGaemCode() {
		return new ArrayList<>(EnumSet.allOf(Game.class));
	}
	
	
}
