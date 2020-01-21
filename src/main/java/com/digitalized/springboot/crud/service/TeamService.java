package com.digitalized.springboot.crud.service;

import java.util.List;

import com.digitalized.springboot.crud.dto.TeamDTO;

public interface TeamService {

	TeamDTO save(TeamDTO team);
	
	List<TeamDTO> findAll();

	TeamDTO findById(int id);

	void deleteById(int id);

}
