package com.digitalized.springboot.crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalized.springboot.crud.dto.PlayerDTO;
import com.digitalized.springboot.crud.service.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerController {
	
	private PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@PostMapping("/players")
	public PlayerDTO addPlayer(@RequestBody PlayerDTO player) {
		player.setId(0);
		return playerService.save(player);
	}
	
	@GetMapping("/players")
	public List<PlayerDTO> findAllPlayers() {
		return playerService.findAll();
	}
	
	@GetMapping("/players/{id}")
	public PlayerDTO getPlayer(@PathVariable int id) {
		return playerService.findById(id);
	}
	
	@PutMapping("/players")
	public PlayerDTO updatePlayer(@RequestBody PlayerDTO player) {
		return playerService.save(player);
	}
	
	@DeleteMapping("/players/{id}")
	public String detelePlayer(@PathVariable int id) {
		playerService.deleteById(id);
		return "Player with id: " + id + " successfully deleted!";
	}
	
}
