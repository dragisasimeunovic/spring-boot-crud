package com.digitalized.springboot.crud.service;

import java.util.List;

import com.digitalized.springboot.crud.dto.PlayerDTO;

public interface PlayerService {

	PlayerDTO save(PlayerDTO playerDTO);
	
	List<PlayerDTO> findAll();
	
	PlayerDTO findById(int id);
	
	void deleteById(int id);
	
}
