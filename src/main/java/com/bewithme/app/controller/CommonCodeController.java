package com.bewithme.app.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bewithme.data.type.Game;
import com.bewithme.data.type.GameType;
import com.bewithme.data.type.Gender;
import com.bewithme.data.type.LolPosition;
import com.bewithme.data.type.LolRole;
import com.bewithme.data.type.BagServer;
import com.bewithme.data.type.BagTier;
import com.bewithme.data.type.LolTier;

@Controller
@RequestMapping("/codes")
public class CommonCodeController {

	@GetMapping("/game")
	@ResponseBody
	public List<Game> getGames() {
		return new ArrayList<>(EnumSet.allOf(Game.class));
	}
	
	@GetMapping("/game/type")
	@ResponseBody
	public List<GameType> getGameTypes() {
		return new ArrayList<>(EnumSet.allOf(GameType.class));
	}
	
	@GetMapping("/gender")
	@ResponseBody
	public List<Gender> getGenders() {
		return new ArrayList<>(EnumSet.allOf(Gender.class));
	}
	
	@GetMapping("/lol/position")
	@ResponseBody
	public List<LolPosition> getLolPositions() {
		return new ArrayList<>(EnumSet.allOf(LolPosition.class));
	}
	
	@GetMapping("/lol/role")
	@ResponseBody
	public List<LolRole> getLolRoles() {
		return new ArrayList<>(EnumSet.allOf(LolRole.class));
	}
	
	@GetMapping("/lol/tier")
	@ResponseBody
	public List<LolTier> getLolTiers() {
		return new ArrayList<>(EnumSet.allOf(LolTier.class));
	}
	
	@GetMapping("/bag/server")
	@ResponseBody
	public List<BagServer> getBagServers() {
		return new ArrayList<>(EnumSet.allOf(BagServer.class));
	}
	
	@GetMapping("/bag/tier")
	@ResponseBody
	public List<BagTier> getBagTiers() {
		return new ArrayList<>(EnumSet.allOf(BagTier.class));
	}
	
}
