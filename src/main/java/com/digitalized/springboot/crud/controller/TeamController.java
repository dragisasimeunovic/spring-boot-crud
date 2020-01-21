package com.digitalized.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalized.springboot.crud.dto.PlayerDTO;
import com.digitalized.springboot.crud.dto.TeamDTO;
import com.digitalized.springboot.crud.service.TeamService;

@RestController
@RequestMapping("/api")
public class TeamController {

	private TeamService teamService;
	
	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	@PostMapping("/teams")
	public TeamDTO addTeam(@RequestBody TeamDTO teamDTO) {
		teamDTO.setId(0);
		return teamService.save(teamDTO);
	}
	
	@GetMapping("/teams")
	public List<TeamDTO> findAllTeams() {
		return teamService.findAll();
	}
	
	@GetMapping("/teams/{id}")
	public TeamDTO getTeam(@PathVariable int id) {
		return teamService.findById(id);
	}
	
	@PutMapping("/teams")
	public TeamDTO updateTeam(@RequestBody TeamDTO teamDTO) {
		return teamService.save(teamDTO);
	}
	
	@DeleteMapping("/teams/{id}")
	public String deleteTeam(@PathVariable int id) {
		teamService.deleteById(id);
		return "Team with id: " + id + " successfully deleted!";
	}
	
}
