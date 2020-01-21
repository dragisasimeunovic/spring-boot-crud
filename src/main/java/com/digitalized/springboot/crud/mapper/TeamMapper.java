package com.digitalized.springboot.crud.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalized.springboot.crud.dto.TeamDTO;
import com.digitalized.springboot.crud.entity.Team;

public class TeamMapper {

	public static TeamDTO toDTO(Team entity) {
		return TeamDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.country(entity.getCountry())
				.build();
	}
	
	public static List<TeamDTO> toDTOs(List<Team> entities) {
		return entities.stream().map(TeamMapper::toDTO).collect(Collectors.toList());
		//return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}
	
	public static Team toEntity(TeamDTO dto) {
		return Team.builder()
				.id(dto.getId())
				.name(dto.getName())
				.country(dto.getCountry())
				.build();
	}
	
	public static List<Team> toEntities(List<TeamDTO> dtos) {
		return dtos.stream().map(TeamMapper::toEntity).collect(Collectors.toList());
	}
	
}
