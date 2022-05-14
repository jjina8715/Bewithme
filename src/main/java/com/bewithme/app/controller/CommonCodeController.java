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
import com.bewithme.data.type.PositionLol;
import com.bewithme.data.type.RoleLol;
import com.bewithme.data.type.ServerBag;
import com.bewithme.data.type.TierBag;
import com.bewithme.data.type.TierLol;

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
	public List<PositionLol> getLolPositions() {
		return new ArrayList<>(EnumSet.allOf(PositionLol.class));
	}
	
	@GetMapping("/lol/role")
	@ResponseBody
	public List<RoleLol> getLolRoles() {
		return new ArrayList<>(EnumSet.allOf(RoleLol.class));
	}
	
	@GetMapping("/lol/tier")
	@ResponseBody
	public List<TierLol> getLolTiers() {
		return new ArrayList<>(EnumSet.allOf(TierLol.class));
	}
	
	@GetMapping("/bag/server")
	@ResponseBody
	public List<ServerBag> getBagServers() {
		return new ArrayList<>(EnumSet.allOf(ServerBag.class));
	}
	
	@GetMapping("/bag/tier")
	@ResponseBody
	public List<TierBag> getBagTiers() {
		return new ArrayList<>(EnumSet.allOf(TierBag.class));
	}
	
}
