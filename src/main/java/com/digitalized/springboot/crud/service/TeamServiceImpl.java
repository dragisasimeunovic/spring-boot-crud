package com.digitalized.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalized.springboot.crud.dto.TeamDTO;
import com.digitalized.springboot.crud.entity.Team;
import com.digitalized.springboot.crud.exception.EmployeeException;
import com.digitalized.springboot.crud.mapper.TeamMapper;
import com.digitalized.springboot.crud.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepository teamRepository;
	
	@Autowired
	public TeamServiceImpl(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	@Override
	@Transactional
	public TeamDTO save(TeamDTO teamDTO) {
		Team team = TeamMapper.toEntity(teamDTO);
		teamRepository.save(team);
		return TeamMapper.toDTO(team);
	}
	
	@Override
	@Transactional
	public List<TeamDTO> findAll() {
		return TeamMapper.toDTOs(teamRepository.findAll());
	}

	@Override
	@Transactional
	public TeamDTO findById(int id) {
		Optional<Team> team = teamRepository.findById(id);
		
		if (!team.isPresent()) {
			throw new EmployeeException("'team' entity with id: " + id + " not found!");
		}
		return TeamMapper.toDTO(team.get());
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		Optional<Team> team = teamRepository.findById(id);
		
		if (!team.isPresent()) {
			throw new EmployeeException("'team' entity with id: " + id + " not found!");
		}
		
		team.ifPresent(t -> t.getPlayers().forEach(player -> player.setTeam(null)));
		
		teamRepository.deleteById(id);
	}

}
