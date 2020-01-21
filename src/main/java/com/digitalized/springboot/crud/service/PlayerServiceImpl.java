package com.digitalized.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalized.springboot.crud.dto.PlayerDTO;
import com.digitalized.springboot.crud.dto.TeamDTO;
import com.digitalized.springboot.crud.entity.Player;
import com.digitalized.springboot.crud.exception.EmployeeException;
import com.digitalized.springboot.crud.mapper.PlayerMapper;
import com.digitalized.springboot.crud.mapper.TeamMapper;
import com.digitalized.springboot.crud.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;
	private TeamService teamService;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository playerRepository, TeamService teamService) {
		this.playerRepository = playerRepository;
		this.teamService = teamService;
	}
	
	@Override
	@Transactional
	public PlayerDTO save(PlayerDTO playerDTO) {
		Player player = PlayerMapper.toEntity(playerDTO);
		
		if (player.getTeam() != null) {
			TeamDTO team = teamService.findById(player.getTeam().getId());
			player.setTeam(TeamMapper.toEntity(team));
		}
		
		playerRepository.save(player);
		
		return PlayerMapper.toDTO(player);
	}

	@Override
	@Transactional
	public List<PlayerDTO> findAll() {
		return PlayerMapper.toDTOs(playerRepository.findAll());
	}

	@Override
	@Transactional
	public PlayerDTO findById(int id) {
		
		Optional<Player> player = playerRepository.findById(id);
		if (!player.isPresent()) {
			throw new EmployeeException("'player' entity with id: " + id + " not found!");
		}
		
		return PlayerMapper.toDTO(player.get());
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		Optional<Player> player = playerRepository.findById(id);
		if (!player.isPresent()) {
			throw new EmployeeException("'player' entity with id: " + id + " not found!");
		}
		
		playerRepository.deleteById(id);
	}

}
