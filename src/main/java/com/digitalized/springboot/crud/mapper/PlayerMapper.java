package com.digitalized.springboot.crud.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalized.springboot.crud.dto.PlayerDTO;
import com.digitalized.springboot.crud.entity.Player;

public class PlayerMapper {

	public static PlayerDTO toDTO(Player entity) {
		return PlayerDTO.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.age(entity.getAge())
				.team(entity.getTeam() != null ? TeamMapper.toDTO(entity.getTeam()) : null)
				.build();
	}
	
	public static List<PlayerDTO> toDTOs(List<Player> entities) {
		return entities.stream().map(PlayerMapper::toDTO).collect(Collectors.toList());
	}
	
	public static Player toEntity(PlayerDTO dto) {
		return Player.builder()
				.id(dto.getId())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.age(dto.getAge())
				.team(dto.getTeam() != null ? TeamMapper.toEntity(dto.getTeam()) : null)
				.build();
	}
	
	public static List<Player> toEntities(List<PlayerDTO> dtos) {
		return dtos.stream().map(PlayerMapper::toEntity).collect(Collectors.toList());
	}
	
}
